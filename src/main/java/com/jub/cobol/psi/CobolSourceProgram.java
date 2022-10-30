package com.jub.cobol.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.jub.cobol.CobolFileType;
import com.jub.cobol.CobolLanguage;
import org.jetbrains.annotations.NotNull;

public class CobolSourceProgram extends PsiFileBase {

    public CobolSourceProgram(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, CobolLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return CobolFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Cobol Source Program";
    }

}
