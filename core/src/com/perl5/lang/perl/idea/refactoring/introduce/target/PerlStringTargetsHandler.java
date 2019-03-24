/*
 * Copyright 2015-2018 Alexandr Evstigneev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.perl5.lang.perl.idea.refactoring.introduce.target;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiUtilCore;
import com.perl5.lang.perl.idea.refactoring.introduce.PerlIntroduceTarget;
import com.perl5.lang.perl.psi.PerlString;
import com.perl5.lang.perl.psi.PerlStringList;
import com.perl5.lang.perl.psi.PsiPerlStringBare;
import com.perl5.lang.perl.psi.impl.PsiPerlStringBareImpl;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.perl5.lang.perl.lexer.PerlElementTypesGenerated.LP_STRING_QW;
import static com.perl5.lang.perl.lexer.PerlTokenSets.STRING_CONTENT_TOKENSET;

/**
 * Compute target for quoted entities(perl strings) by caret position.
 */
class PerlStringTargetsHandler extends PerlIntroduceTargetsHandler {
  public static final PerlIntroduceTargetsHandler INSTANCE = new PerlStringTargetsHandler();
  private static final Logger LOG = Logger.getInstance(PerlStringTargetsHandler.class);

  private PerlStringTargetsHandler() {
  }

  @NotNull
  @Override
  protected List<PerlIntroduceTarget> computeTargetsAtCaret(@NotNull PsiElement element, int caretOffset) {
    if (!(element instanceof PerlString)) {
      LOG.error("Incorrect element passed to collector: " + element + " " + element.getClass());
      return Collections.emptyList();
    }

    if (element instanceof PsiPerlStringBareImpl) {
      return computeBareStringTarget(element);
    }

    PerlString perlStringElement = (PerlString)element;
    List<PsiElement> allChildren = perlStringElement.getAllChildrenList();
    if (allChildren.isEmpty()) {
      return Collections.singletonList(PerlIntroduceTarget.create(element));
    }


    List<PerlIntroduceTarget> result = new ArrayList<>();
    int firstStringElementStartOffsetInParent = allChildren.get(0).getStartOffsetInParent();

    for (PsiElement stringRun : allChildren) {
      IElementType stringRunElementType = PsiUtilCore.getElementType(stringRun);
      TextRange stringRunTextRange = stringRun.getTextRange();
      if (stringRunTextRange.contains(caretOffset) || stringRunTextRange.getStartOffset() > caretOffset) {
        if (STRING_CONTENT_TOKENSET.contains(stringRunElementType)) {
          String stringRunText = stringRun.getText();
          boolean isLastWhiteSpace = true;
          for (int i = 0; i < stringRunText.length(); i++) {
            boolean isCurrentWhiteSpace = Character.isWhitespace(stringRunText.charAt(i));
            int substringEndOffsetInParent = stringRun.getStartOffsetInParent() + i;
            if (isLastWhiteSpace != isCurrentWhiteSpace && isCurrentWhiteSpace &&
                substringEndOffsetInParent + stringRunTextRange.getStartOffset() > caretOffset) {
              result.add(PerlIntroduceTarget.create(perlStringElement, firstStringElementStartOffsetInParent,
                                                    substringEndOffsetInParent));
            }
            isLastWhiteSpace = isCurrentWhiteSpace;
          }
          if (!isLastWhiteSpace) {
            result.add(PerlIntroduceTarget.create(perlStringElement, firstStringElementStartOffsetInParent,
                                                  stringRun.getStartOffsetInParent() + stringRunText.length()));
          }
        }
        else {
          result.add(PerlIntroduceTarget.create(perlStringElement, allChildren.get(0), stringRun));
        }
      }
    }
    result.add(PerlIntroduceTarget.create(element));
    return result;
  }

  @NotNull
  private List<PerlIntroduceTarget> computeBareStringTarget(@NotNull PsiElement element) {
    PsiElement elementParent = element.getParent();
    if (PsiUtilCore.getElementType(elementParent) == LP_STRING_QW) {
      elementParent = elementParent.getParent();
    }

    return elementParent instanceof PerlStringList ?
           Collections.singletonList(PerlIntroduceTarget.create(elementParent, element, element)) :
           Collections.singletonList(PerlIntroduceTarget.create(element));
  }

  @NotNull
  @Override
  protected List<PerlIntroduceTarget> computeTargetsFromSelection(@NotNull PsiElement element, @NotNull TextRange selectionRange) {
    if (!(element instanceof PerlString)) {
      LOG.error("Incorrect element passed to collector: " + element + " " + element.getClass());
      return Collections.emptyList();
    }

    if (element instanceof PsiPerlStringBare) {
      return computeBareStringTarget(element);
    }

    List<PsiElement> allChildrenList = ((PerlString)element).getAllChildrenList();
    if (allChildrenList.isEmpty()) {
      return Collections.singletonList(PerlIntroduceTarget.create(element));
    }

    int selectionStart = selectionRange.getStartOffset();
    int selectionEnd = selectionRange.getEndOffset();

    if (allChildrenList.get(0).getTextRange().getStartOffset() >= selectionStart &&
        allChildrenList.get(allChildrenList.size() - 1).getTextRange().getEndOffset() <= selectionEnd) {
      return Collections.singletonList(PerlIntroduceTarget.create(element));
    }

    int elementStartOffset = element.getTextRange().getStartOffset();
    int startOffset = -1;
    int endOffset = -1;
    for (PsiElement run : allChildrenList) {
      IElementType runElementType = PsiUtilCore.getElementType(run);
      TextRange runTextRange = run.getTextRange();
      if (runTextRange.getEndOffset() <= selectionStart || runTextRange.getStartOffset() >= selectionEnd) {
        continue;
      }

      if (startOffset < 0) {
        startOffset = runTextRange.getStartOffset();
        if (selectionStart > startOffset && STRING_CONTENT_TOKENSET.contains(runElementType)) {
          startOffset = selectionStart;
        }
      }
      endOffset = runTextRange.getEndOffset();
      if (selectionEnd < endOffset && STRING_CONTENT_TOKENSET.contains(runElementType)) {
        endOffset = selectionEnd;
      }
    }
    return startOffset < 0 || endOffset < 0 ? Collections.emptyList() :
           Collections.singletonList(PerlIntroduceTarget.create(element, startOffset - elementStartOffset, endOffset - elementStartOffset));
  }

  @NotNull
  @Override
  protected String createTargetExpressionText(@NotNull PerlIntroduceTarget target) {
    PsiElement targetPlace = target.getPlace();
    if (targetPlace instanceof PsiPerlStringBare) {
      return createBarewordQuotedText(targetPlace.getText());
    }
    return super.createTargetExpressionText(target);
  }

  @NotNull
  static String createBarewordQuotedText(@NotNull String content) {
    return "'" + StringUtil.escapeChar(content, '\'') + "'";
  }
}
