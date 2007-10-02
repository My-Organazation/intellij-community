/*
 * Copyright 2000-2007 JetBrains s.r.o.
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

package org.jetbrains.plugins.groovy.lang.psi.impl.statements.params;

import com.intellij.lang.ASTNode;
import com.intellij.psi.*;
import com.intellij.psi.impl.PsiManagerEx;
import com.intellij.psi.search.LocalSearchScope;
import com.intellij.psi.search.SearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.psi.util.TypeConversionUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.plugins.groovy.lang.psi.GroovyElementVisitor;
import org.jetbrains.plugins.groovy.lang.psi.api.auxiliary.modifiers.GrModifierList;
import org.jetbrains.plugins.groovy.lang.psi.api.statements.GrParametersOwner;
import org.jetbrains.plugins.groovy.lang.psi.api.statements.clauses.GrForInClause;
import org.jetbrains.plugins.groovy.lang.psi.api.statements.expressions.GrExpression;
import org.jetbrains.plugins.groovy.lang.psi.api.statements.expressions.arithmetic.GrRangeExpression;
import org.jetbrains.plugins.groovy.lang.psi.api.statements.params.GrParameter;
import org.jetbrains.plugins.groovy.lang.psi.api.types.GrTypeElement;
import org.jetbrains.plugins.groovy.lang.psi.impl.statements.GrVariableImpl;

/**
 * @author: Dmitry.Krasilschikov
 * @date: 26.03.2007
 */
public class GrParameterImpl extends GrVariableImpl implements GrParameter {
  public GrParameterImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(GroovyElementVisitor visitor) {
    visitor.visitParameter(this);
  }

  public String toString() {
    return "Parameter";
  }

  @Nullable
  public PsiType getTypeGroovy() {
    GrTypeElement typeElement = getTypeElementGroovy();
    if (typeElement != null) return typeElement.getType();
    PsiElement parent = getParent();
    if (parent instanceof GrForInClause) {
      GrExpression iteratedExpression = ((GrForInClause) parent).getIteratedExpression();
      if (iteratedExpression instanceof GrRangeExpression) {
        return getManager().getElementFactory().createTypeByFQClassName("java.lang.Integer", getResolveScope());
      } else if (iteratedExpression != null) {
        PsiType iterType = iteratedExpression.getType();
        if (iterType instanceof PsiArrayType) return ((PsiArrayType) iterType).getComponentType();
        if (iterType instanceof PsiClassType) {
          PsiClassType.ClassResolveResult result = ((PsiClassType) iterType).resolveGenerics();
          PsiClass clazz = result.getElement();
          if (clazz != null) {
            PsiManagerEx manager = getManager();
            PsiClass collectionClass = manager.findClass("java.util.Collection", getResolveScope());
            if (collectionClass != null && collectionClass.getTypeParameters().length == 1) {
              PsiSubstitutor substitutor = TypeConversionUtil.getClassSubstitutor(collectionClass, clazz, result.getSubstitutor());
              if (substitutor != null) {
                PsiType substed = substitutor.substitute(collectionClass.getTypeParameters()[0]);
                if (substed != null) {
                  return substed;
                }
              }
            }

            if ("java.lang.String".equals(clazz.getQualifiedName())) {
              return manager.getElementFactory().createTypeByFQClassName("java.lang.Character", getResolveScope());
            }
          }
        }
      }
    }

    return null;
  }

  public void setType(@Nullable PsiType type) {
    throw new RuntimeException("NIY");
  }

  @Nullable
  public GrTypeElement getTypeElementGroovy() {
    return findChildByClass(GrTypeElement.class);
  }

  @Nullable
  public GrExpression getDefaultInitializer() {
    return findChildByClass(GrExpression.class);
  }

  public boolean isOptional() {
    return getDefaultInitializer() != null;
  }

  @NotNull
  public SearchScope getUseScope() {
    if (!isPhysical()) {
      final PsiFile file = getContainingFile();
      final PsiElement context = file.getContext();
      if (context != null) return new LocalSearchScope(context);
      return super.getUseScope();
    }

    return new LocalSearchScope(getDeclarationScope());
  }

  @NotNull
  public String getName() {
    return getNameIdentifierGroovy().getText();
  }

  public int getTextOffset() {
    return getNameIdentifierGroovy().getTextRange().getStartOffset();
  }

  @Nullable
  public GrModifierList getModifierList() {
    return findChildByClass(GrModifierList.class);
  }

  @NotNull
  public PsiElement getDeclarationScope() {
    final GrParametersOwner owner = PsiTreeUtil.getParentOfType(this, GrParametersOwner.class);
    assert owner != null;
    if (owner instanceof GrForInClause) return owner.getParent();
    return owner;
  }

  public boolean isVarArgs() {
    return false;
  }

  @NotNull
  public PsiAnnotation[] getAnnotations() {
    return PsiAnnotation.EMPTY_ARRAY;
  }
}
