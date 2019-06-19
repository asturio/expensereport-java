package com.nelkinda.training;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpenseHtmlReporterTest {
    private final static String EOL = System.lineSeparator();

    @Test
    public void testHtmlReport() {
        ExpenseHtmlReporter reporter = new ExpenseHtmlReporter();
        String result = reporter.generateReport();
        String expected = "<html>" + EOL
                + "<head>" + EOL
                + "</head>" + EOL
                + "<body>" + EOL
                + "</body>" + EOL
                + "</html>" + EOL;
        assertEquals(expected, result);
    }
}
