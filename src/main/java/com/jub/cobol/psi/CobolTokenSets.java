package com.jub.cobol.psi;

import com.intellij.psi.tree.TokenSet;

public interface CobolTokenSets {

    TokenSet IDENTIFIERS = TokenSet.create(CobolTypes.ALPHABETIC_USER_DEFINED_WORD);

}
