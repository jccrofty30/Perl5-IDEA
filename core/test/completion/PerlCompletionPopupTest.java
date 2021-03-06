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

package completion;

import base.PerlCompletionPopupTestCase;
import com.perl5.lang.perl.fileTypes.PerlFileTypePackage;
import com.perl5.lang.perl.idea.codeInsight.Perl5CodeInsightSettings;

public class PerlCompletionPopupTest extends PerlCompletionPopupTestCase {

  @Override
  protected String getTestDataPath() {
    return "testData/completionPopup/perl";
  }

  @Override
  public String getFileExtension() {
    return PerlFileTypePackage.EXTENSION; // requires for package.. test
  }

  public void testSmartCommaSequence() {
    Perl5CodeInsightSettings.getInstance().SMART_COMMA_SEQUENCE_TYPING = true;
    doTest(" ");
  }

  public void testSmartCommaSequenceDisabled() {
    Perl5CodeInsightSettings.getInstance().SMART_COMMA_SEQUENCE_TYPING = false;
    doTestNegative(" ");
  }

  public void testAutoColonUseEnabled() {
    Perl5CodeInsightSettings.getInstance().AUTO_INSERT_COLON = true;
    doTest("use Mojolicious<caret>", ":");
  }

  public void testAutoColonUseDisabled() {
    Perl5CodeInsightSettings.getInstance().AUTO_INSERT_COLON = false;
    doTestNegative("use Mojolicious<caret>", ":");
  }

  public void testScalarCtrl() {doTest("$<caret>", "^");}

  public void testArrayCtrl() {doTest("@<caret>", "^");}

  public void testHashCtrl() {doTest("%<caret>", "^");}

  public void testScalarIndexCtrl() {doTest("$#<caret>", "^");}

  public void testScalarCtrlBraces() {doTest("${<caret>}", "^");}

  public void testArrayCtrlBraces() {doTest("@{<caret>}", "^");}

  public void testHashCtrlBraces() {doTest("%{<caret>}", "^");}

  public void testScalarIndexCtrlBraces() {doTest("$#{<caret>}", "^");}

  public void testUse() {doTest("use<caret>", " ");}

  public void testNo() {doTest("no<caret>", " ");}

  public void testReturns() {doTest("#@returns<caret>", " ");}

  public void testType() {doTest("#@type<caret>", " ");}

  public void testPackage() {doTest("package<caret>", " ");}

  public void testAnnotations() {doTest("#<caret>", "@");}

  public void testObjectMethod() {
    doTest("UNIVERSAL-<caret>", ">");
  }

  public void testStaticMethod() {
    doTest("CORE:<caret>", ":");
  }

  public void testScalarName() {
    doTest("\n<caret>", "$");
  }

  public void testArrayName() {
    doTest("\n<caret>", "@");
  }

  public void testHashName() {
    doTest("\n<caret>", "%");
  }

  public void testArrayIndexName() {
    doTest("\n<caret>", "$#");
  }

  public void testDQOpen() {doTest("", "\"");}

  public void testSQOpen() {doTest("", "'");}

  public void testQOpen() {doTest("q<caret>", "/");}

  public void testQQOpen() {doTest("qq<caret>", "/");}

  public void testQWOpen() {doTest("qw<caret>", "/");}

  public void testQWContinue() {doTest("qw(text1<caret>)", " ");}

  public void testBracedScalar() {doTest("$<caret>", "{");}

  public void testBracedArray() {doTest("@<caret>", "{");}

  public void testBracedHash() {doTest("%<caret>", "{");}

  public void testBracedArrayIndex() {doTest("$#<caret>", "{");}

  public void testBracedGlob() {doTest("*<caret>", "{");}

  public void testHashRefIndexOpen() {doTest("say $a->{something};say $b-><caret>", "{");}

  public void testHashIndexOpen() {doTest("say $a->{something};say $b<caret>", "{");}

  public void testHashGlobIndexOpen() {doTest("say $a->{something};say *b<caret>", "{");}

  public void testSpaceBug() {doTestNegative("qw//<caret>", ";");}

}
