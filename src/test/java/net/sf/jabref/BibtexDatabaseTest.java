package net.sf.jabref;

import net.sf.jabref.imports.BibtexParser;
import net.sf.jabref.imports.ParserResult;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class BibtexDatabaseTest {

    /**
     * Some basic test cases for resolving strings.
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Test
    public void testResolveStrings() throws IOException {

        ParserResult result = BibtexParser.parse(new FileReader("src/test/resources/net/sf/jabref/util/twente.bib"));

        BibtexDatabase db = result.getDatabase();

        assertEquals("Arvind", db.resolveForStrings("#Arvind#"));
        assertEquals("Patterson, David", db.resolveForStrings("#Patterson#"));
        assertEquals("Arvind and Patterson, David", db.resolveForStrings("#Arvind# and #Patterson#"));

        // Strings that are not found return just the given string.
        assertEquals("#unknown#", db.resolveForStrings("#unknown#"));

    }


}
