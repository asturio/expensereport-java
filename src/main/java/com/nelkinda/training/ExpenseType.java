package com.nelkinda.training;

enum ExpenseType {
    BREAKFAST("Breakfast", 1000, true),
    LUNCH("Lunch", 2500, true),
    DINNER("Dinner", 5000, true),
    CAR_RENTAL("Car Rental", Integer.MAX_VALUE, false),
    ;

    private final String name;
    private final int limit;
    private final boolean isMeal;

    ExpenseType(String name, int limit, boolean isMeal) {
        this.name = name;
        this.limit = limit;
        this.isMeal = isMeal;
    }

    public String getName() {
        return name;
    }

    public int getLimit() {
        return limit;
    }

    public boolean isMeal() {
        return isMeal;
    }

    public boolean isOverLimit(int amount) {
        return amount > getLimit();
    }
}
