package com.nelkinda.training;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ExpenseReporterTest {
    private ExpenseReporter underTest = new ExpenseReporter();

    @Test
    void testGenerateReport() {
        // given
        List<Expense> expenses = new ArrayList<>();
        expenses.add(new Expense(ExpenseType.BREAKFAST, 1000));
        expenses.add(new Expense(ExpenseType.BREAKFAST, 1001));
        expenses.add(new Expense(ExpenseType.DINNER, 5000));
        expenses.add(new Expense(ExpenseType.DINNER, 5001));
        expenses.add(new Expense(ExpenseType.CAR_RENTAL, 501));
        final String expected = "Expenses Thu Jan 01 01:00:00 CET 1970\n"
                + "Breakfast	1000	 \n"
                + "Breakfast	1001	X\n"
                + "Dinner	5000	 \n"
                + "Dinner	5001	X\n"
                + "Car Rental	501	 \n"
                + "Meal expenses: 12002\n"
                + "Total expenses: 12503\n";
        // when
        String result = underTest.generateReport(expenses, new Date(0));
        // then
        assertEquals(expected, result);
    }

    @Test
    void testLunch() {
        // given
        List<Expense> expenses = new ArrayList<>();
        expenses.add(new Expense(ExpenseType.LUNCH, 2500));
        expenses.add(new Expense(ExpenseType.LUNCH, 2501));
        final String expected = "Expenses Thu Jan 01 01:00:00 CET 1970\n"
                + "Lunch	2500	 \n"
                + "Lunch	2501	X\n"
                + "Meal expenses: 5001\n"
                + "Total expenses: 5001\n";
        // when
        String result = underTest.generateReport(expenses, new Date(0));
        // then
        assertEquals(expected, result);
    }

    @Test
    void testPrintReport() {
        // given
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        // when
        underTest.printReport(Collections.emptyList());
        String result = baos.toString();
        // then
        assertTrue(result.contains("Meal expenses: 0\n"));
        assertTrue(result.contains("Total expenses: 0\n\n"));
    }
}