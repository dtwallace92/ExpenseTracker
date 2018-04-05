package com.example.dtwal.expenses;

/**
 * Created by dtwal on 4/2/2018.
 */

public class Expense {

    String name, category, date, amount, id;

    public Expense() {

    }

    public Expense(String name, String category, String date, String amount, String id) {
        this.name = name;
        this.category = category;
        this.date = date;
        this.amount = amount;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setId(String id) {

    }
}
