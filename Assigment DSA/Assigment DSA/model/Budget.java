package model;

import java.util.List;

public class Budget {
    private double totalIncome;
    private double totalExpense;
    private double balance;
    private List<Transaction> transactions;

    public Budget(double totalIncome, double totalExpense, double balance, List<Transaction> transactions) {
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
        this.balance = balance;
        this.transactions = transactions;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(double totalExpense) {
        this.totalExpense = totalExpense;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
    // Add transactions to the budget
    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
        if (transaction.getType().equals("Income")) {
            this.totalIncome += transaction.getAmount();
        } else if (transaction.getType().equals("Expense")) {
            this.totalExpense += transaction.getAmount();
        }
        this.balance = this.totalIncome - this.totalExpense;
    }

    @Override
    public String toString() {
        return "Budget{" +
                "totalIncome=" + totalIncome +
                ", totalExpense=" + totalExpense +
                ", balance=" + balance +
                '}';
    }
}
