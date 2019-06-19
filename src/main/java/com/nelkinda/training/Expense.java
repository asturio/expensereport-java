package com.nelkinda.training;

import java.util.List;

class Expense {
    private final ExpenseType type;
    private final int amount;

    public ExpenseType getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    public Expense(ExpenseType type, int amount) {
        this.type = type;
        this.amount = amount;

    }

    public static int sumAllExpenses(List<Expense> expenses) {
        int total = 0;
        for (Expense expense : expenses) {
            total += expense.amount;
        }
        return total;
    }

    public static int sumAllMeals(List<Expense> expenses) {
        int mealExpenses = 0;
        for (Expense expense : expenses) {
            if (expense.type.isMeal()) {
                mealExpenses += expense.amount;
            }
        }
        return mealExpenses;
    }

    public boolean isOverLimit() {
        return type.isOverLimit(amount);
    }

    String getOverExpenseMarker() {
        return isOverLimit() ? "X" : " ";
    }

}
