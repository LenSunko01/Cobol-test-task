package com.jub.cobol;

import com.intellij.testFramework.ParsingTestCase;

public class CobolParsingTest extends ParsingTestCase {

    public CobolParsingTest() {
        super("", "cbl", new CobolParserDefinition());
    }

    public void testParsingTestData() {
        doTest(true);
    }

    /**
     * @return path to test data file directory relative to root of this module.
     */
    @Override
    protected String getTestDataPath() {
        return "src/test/java/com/jub/cobol";
    }

    @Override
    protected boolean skipSpaces() {
        return false;
    }

    @Override
    protected boolean includeRanges() {
        return true;
    }

}
