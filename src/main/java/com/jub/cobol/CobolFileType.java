package com.jub.cobol;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class CobolFileType extends LanguageFileType {

    public static final CobolFileType INSTANCE = new CobolFileType();

    private CobolFileType() {
        super(CobolLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Cobol File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Cobol language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "cbl";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return CobolIcons.FILE;
    }

}