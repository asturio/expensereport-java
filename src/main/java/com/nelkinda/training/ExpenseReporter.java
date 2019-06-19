package com.nelkinda.training;

import java.util.Date;
import java.util.List;

public class ExpenseReporter {
    private static final String EOL = System.lineSeparator();

    public void printReport(List<Expense> expenses) {
        String report = generateReport(expenses, new Date());
        System.out.println(report);
    }

    String generateReport(List<Expense> expenses, Date date) {
        return generateHeader(date) + generateBody(expenses) + generateFooter(expenses);
    }

    private String generateHeader(Date date) {
        return "Expenses " + date + EOL;
    }

    private String generateBody(List<Expense> expenses) {
        StringBuilder body = new StringBuilder();
        for (Expense expense : expenses) {
            body.append(expense.getType().getName()).append("\t")
                    .append(expense.getAmount()).append("\t")
                    .append(expense.getOverExpenseMarker()).append(EOL);
        }
        return body.toString();
    }

    private String generateFooter(List<Expense> expenses) {
        int mealExpenses = Expense.sumAllMeals(expenses);
        int total = Expense.sumAllExpenses(expenses);
        return "Meal expenses: " + mealExpenses + EOL
                + ("Total expenses: " + total + EOL);
    }
}
