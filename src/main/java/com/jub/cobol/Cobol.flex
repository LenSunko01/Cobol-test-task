package com.jub.cobol;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.jub.cobol.psi.CobolTypes;
import com.intellij.psi.TokenType;

%%

%class CobolLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}


LINE_NUMBER = [0-9] [0-9]
IDENTIFICATION="IDENTIFICATION"
DIVISION="DIVISION"
DOT="."
NEWLINE=\n
COBOL_PROGRAM_ID="PROGRAM-ID"
DATA="DATA"
WORKING_STORAGE="WORKING-STORAGE"
SECTION="SECTION"
FILLER="FILLER"
PIC="PIC"
REPEAT = "(" [0-9]+ ")"
PUNCTUATION = [\/\,\.\:]
VALUE = "VALUE"
NUMERIC = [\+\-]?([0-9]*[\.][0-9]+|[0-9]+)
WHITE_SPACE=[\ \t\f]
ALPHABETIC_USER_DEFINED_WORD = ([0-9]+[\-]*)*[0-9]*[A-Za-z][A-Za-z0-9]*([\-]+[A-Za-z0-9]+)*
CURRENCY = [^0-9ABCDPRSVXZa-z\*\+\-\/\,\.\;\(\)\=\'\"\ \n]
PICCHAR = ( [ABEGPSVXZabegpsvxz90\+\-\*\$] | "CR" | "DB" )
PROCEDURE = "PROCEDURE"
STOPRUN = "STOP RUN"
PERFORM = "PERFORM"
VARYING = "VARYING"
FROM = "FROM"
BY = "BY"
UNTIL = "UNTIL"
EQUAL_SYMBOL = "="
DISPLAY = "DISPLAY"
SINGLE_QUOTE = \'
DOUBLE_QUOTE = \"
NONNUMERIC = ({SINGLE_QUOTE}[^\'\\\n]+{SINGLE_QUOTE} | {DOUBLE_QUOTE}[^\'\\\n]+{DOUBLE_QUOTE})

%state WAITING_NUMERIC WAITING_BASIS

%%

<YYINITIAL> {LINE_NUMBER}                                   { yybegin(YYINITIAL); return CobolTypes.LINE_NUMBER; }

<YYINITIAL> {IDENTIFICATION}                                { yybegin(YYINITIAL); return CobolTypes.IDENTIFICATION; }

<YYINITIAL> {DIVISION}                                      { yybegin(YYINITIAL); return CobolTypes.DIVISION; }

<YYINITIAL> {DOT}                                           { yybegin(YYINITIAL); return CobolTypes.DOT; }

<YYINITIAL> {COBOL_PROGRAM_ID}                              { yybegin(YYINITIAL); return CobolTypes.COBOL_PROGRAM_ID; }

<YYINITIAL> {DATA}                                          { yybegin(YYINITIAL); return CobolTypes.DATA; }

<YYINITIAL> {WORKING_STORAGE}                               { yybegin(YYINITIAL); return CobolTypes.WORKING_STORAGE; }

<YYINITIAL> {SECTION}                                       { yybegin(YYINITIAL); return CobolTypes.SECTION; }

<YYINITIAL> {FILLER}                                        { yybegin(YYINITIAL); return CobolTypes.FILLER; }

<YYINITIAL> {PIC}                                           { yybegin(YYINITIAL); return CobolTypes.PIC; }

<YYINITIAL> {CURRENCY}                                      { yybegin(YYINITIAL); return CobolTypes.CURRENCY; }

<WAITING_NUMERIC, WAITING_BASIS> {NUMERIC}                  { yybegin(YYINITIAL); return CobolTypes.NUMERIC; }

<YYINITIAL> {PICCHAR}                                       { yybegin(YYINITIAL); return CobolTypes.PICCHAR; }

<YYINITIAL> {REPEAT}                                        { yybegin(YYINITIAL); return CobolTypes.REPEAT; }

<YYINITIAL> {PUNCTUATION}                                   { yybegin(YYINITIAL); return CobolTypes.PUNCTUATION; }

<YYINITIAL> {NONNUMERIC}                                    { yybegin(YYINITIAL); return CobolTypes.NONNUMERIC; }

<YYINITIAL> {VALUE}                                         { yybegin(WAITING_NUMERIC); return CobolTypes.VALUE; }

<YYINITIAL> {PROCEDURE}                                     { yybegin(YYINITIAL); return CobolTypes.PROCEDURE; }

<YYINITIAL> {STOPRUN}                                       { yybegin(YYINITIAL); return CobolTypes.STOPRUN; }

<YYINITIAL> {PERFORM}                                       { yybegin(YYINITIAL); return CobolTypes.PERFORM; }

<YYINITIAL> {VARYING}                                       { yybegin(YYINITIAL); return CobolTypes.VARYING; }

<YYINITIAL> {FROM}                                          { yybegin(WAITING_NUMERIC); return CobolTypes.FROM; }

<YYINITIAL> {BY}                                            { yybegin(WAITING_NUMERIC); return CobolTypes.BY; }

<YYINITIAL> {UNTIL}                                         { yybegin(YYINITIAL); return CobolTypes.UNTIL; }

<YYINITIAL> {DISPLAY}                                       { yybegin(YYINITIAL); return CobolTypes.DISPLAY; }

<YYINITIAL> {EQUAL_SYMBOL}                                  { yybegin(WAITING_BASIS); return CobolTypes.EQUAL_SYMBOL; }

<YYINITIAL, WAITING_BASIS> {ALPHABETIC_USER_DEFINED_WORD}   { yybegin(YYINITIAL); return CobolTypes.ALPHABETIC_USER_DEFINED_WORD; }

{WHITE_SPACE}                                               { return TokenType.WHITE_SPACE; }

{NEWLINE}                                                   { yybegin(YYINITIAL); return CobolTypes.NEWLINE; }

[^]                                                         { return TokenType.BAD_CHARACTER; }