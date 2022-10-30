package com.jub.cobol;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.jub.cobol.psi.CobolTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class CobolSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey LINE_NUMBER =
            createTextAttributesKey("LINE_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey EQUAL =
            createTextAttributesKey("EQUAL", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey ALPHABETIC_USER_DEFINED_WORD =
            createTextAttributesKey("ALPHABETIC_USER_DEFINED_WORD", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey KEYWORD =
            createTextAttributesKey("KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};
    private static final TextAttributesKey[] EQUAL_KEYS = new TextAttributesKey[]{EQUAL};
    private static final TextAttributesKey[] LINE_NUMBER_KEYS = new TextAttributesKey[]{LINE_NUMBER};
    private static final TextAttributesKey[] ALPHABETIC_USER_DEFINED_WORD_KEYS = new TextAttributesKey[]{ALPHABETIC_USER_DEFINED_WORD};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new CobolLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(CobolTypes.COBOL_PROGRAM_ID)
                || tokenType.equals(CobolTypes.IDENTIFICATION)
                || tokenType.equals(CobolTypes.DIVISION)
                || tokenType.equals(CobolTypes.DATA)
                || tokenType.equals(CobolTypes.WORKING_STORAGE)
                || tokenType.equals(CobolTypes.SECTION)
                || tokenType.equals(CobolTypes.FILLER)
                || tokenType.equals(CobolTypes.PIC)
                || tokenType.equals(CobolTypes.VALUE)
                || tokenType.equals(CobolTypes.PROCEDURE)
                || tokenType.equals(CobolTypes.STOPRUN)
                || tokenType.equals(CobolTypes.PERFORM)
                || tokenType.equals(CobolTypes.VARYING)
                || tokenType.equals(CobolTypes.FROM)
                || tokenType.equals(CobolTypes.BY)
                || tokenType.equals(CobolTypes.UNTIL)
                || tokenType.equals(CobolTypes.DISPLAY)
                || tokenType.equals(CobolTypes.DOT)
        ) {
            return KEYWORD_KEYS;
        }
        if (tokenType.equals(CobolTypes.LINE_NUMBER)) {
            return LINE_NUMBER_KEYS;
        }
        if (tokenType.equals(CobolTypes.EQUAL_SYMBOL)) {
            return EQUAL_KEYS;
        }
        if (tokenType.equals(CobolTypes.ALPHABETIC_USER_DEFINED_WORD)) {
            return ALPHABETIC_USER_DEFINED_WORD_KEYS;
        }
        return EMPTY_KEYS;
    }

}