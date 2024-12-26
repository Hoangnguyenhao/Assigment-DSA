package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Transaction;
import java.util.ArrayList;

public class DashboardController {

    @FXML
    private Label totalIncomeLabel;
    @FXML
    private Label totalExpenseLabel;
    @FXML
    private Label currentBalanceLabel;

    private ArrayList<Transaction> transactionList = new ArrayList<>();

    // Update the dashboard labels based on current transactions
    public void updateDashboard() {
        double totalIncome = 0;
        double totalExpense = 0;
        for (Transaction transaction : transactionList) {
            if (transaction.getType().equals("Income")) {
                totalIncome += transaction.getAmount();
            } else if (transaction.getType().equals("Expense")) {
                totalExpense += transaction.getAmount();
            }
        }
        totalIncomeLabel.setText("Total Income: $" + totalIncome);
        totalExpenseLabel.setText("Total Expense: $" + totalExpense);
        currentBalanceLabel.setText("Balance: $" + (totalIncome - totalExpense));
    }
}
