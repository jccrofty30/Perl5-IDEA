/*
 * Copyright 2015 Alexandr Evstigneev
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

package com.perl5.lang.perl.psi.impl;

import com.intellij.openapi.util.AtomicNotNullLazyValue;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.SearchScope;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.IncorrectOperationException;
import com.perl5.lang.perl.psi.PerlGlobVariable;
import com.perl5.lang.perl.psi.PerlVariableNameElement;
import com.perl5.lang.perl.psi.PerlVisitor;
import com.perl5.lang.perl.psi.references.PerlGlobVariableNameReference;
import com.perl5.lang.perl.psi.references.PerlVariableNameReference;
import com.perl5.lang.perl.psi.utils.PerlElementFactory;
import com.perl5.lang.perl.util.PerlPackageUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by hurricup on 25.05.2015.
 */
public class PerlVariableNameElementImpl extends LeafPsiElement implements PerlVariableNameElement
{
	protected final AtomicNotNullLazyValue<PsiReference[]> myReferences = new AtomicNotNullLazyValue<PsiReference[]>()
	{
		@NotNull
		@Override
		protected PsiReference[] compute()
		{
			if (getParent() instanceof PerlGlobVariable)
				return new PsiReference[]{new PerlGlobVariableNameReference(PerlVariableNameElementImpl.this, null)};
			else
				return new PsiReference[]{new PerlVariableNameReference(PerlVariableNameElementImpl.this, null)};
		}
	};

	public PerlVariableNameElementImpl(@NotNull IElementType type, CharSequence text)
	{
		super(type, text);
	}

	@Override
	public void accept(@NotNull PsiElementVisitor visitor)
	{
		if (visitor instanceof PerlVisitor) ((PerlVisitor) visitor).visitVariableNameElement(this);
		else super.accept(visitor);
	}

	@Override
	public PsiElement setName(@NotNull String name) throws IncorrectOperationException
	{
		PerlVariableNameElement newName = PerlElementFactory.createVariableName(getProject(), name);
		if (newName != null)
			replace(newName);
		else
			throw new IncorrectOperationException("Unable to create new variable name from: " + name);
		return this;
	}

	@Nullable
	@Override
	public PsiElement getNameIdentifier()
	{
		return this;
	}

	@NotNull
	@Override
	public String getName()
	{
		return PerlPackageUtil.getCanonicalPackageName(this.getText());
	}

	@NotNull
	@Override
	public PsiReference[] getReferences()
	{
		return myReferences.getValue();
	}

	@Override
	public PsiReference getReference()
	{
		return myReferences.getValue()[0];
	}

	@Override
	public String getPresentableName()
	{
		return getName();
	}

	@NotNull
	@Override
	public SearchScope getUseScope()
	{
		return getParent().getUseScope();
//		return super.getUseScope();
	}

	@NotNull
	@Override
	public GlobalSearchScope getResolveScope()
	{
		return getParent().getResolveScope();
//		return super.getResolveScope();
	}
}
