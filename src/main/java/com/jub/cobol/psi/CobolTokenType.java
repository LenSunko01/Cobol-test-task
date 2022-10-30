package com.jub.cobol.psi;

import com.intellij.psi.tree.IElementType;
import com.jub.cobol.CobolLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class CobolTokenType extends IElementType {

    public CobolTokenType(@NotNull @NonNls String debugName) {
        super(debugName, CobolLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "CobolTokenType." + super.toString();
    }

}
