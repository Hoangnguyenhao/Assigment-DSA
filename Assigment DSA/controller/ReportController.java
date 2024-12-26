package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import model.Transaction;
import java.util.ArrayList;

public class ReportController {

    @FXML
    private Label incomeReportLabel;
    @FXML
    private Label expenseReportLabel;
    @FXML
    private Label balanceReportLabel;

    private ArrayList<Transaction> transactionList = new ArrayList<>(); // List to store transactions

    // Method to generate the report
    public void generateReport(ActionEvent actionEvent) {
        double totalIncome = 0;
        double totalExpense = 0;

        // Calculate total income and total expense
        for (Transaction transaction : transactionList) {
            if (transaction.getType().equalsIgnoreCase("Income")) {
                totalIncome += transaction.getAmount();
            } else if (transaction.getType().equalsIgnoreCase("Expense")) {
                totalExpense += transaction.getAmount();
            }
        }

        // Update the labels with the report data
        incomeReportLabel.setText("Total Income: $" + totalIncome);
        expenseReportLabel.setText("Total Expense: $" + totalExpense);
        balanceReportLabel.setText("Balance: $" + (totalIncome - totalExpense));
    }

    // Handle the action of closing the report screen
    public void handleCloseReport(ActionEvent actionEvent) {
        // Here you can add logic to close the report window or navigate to another view
        // For example:
        // Stage = (Stage) closeButton.getScene().getWindow();
        // stage.close();
        System.out.println("Closing Report Window...");
    }

    // Method to show a message (optional, for custom error handling)
    private void showMessage(String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(type.toString());
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // You can add a method to set the transaction list from the main controller or load it from a file/database
    public void setTransactionList(ArrayList<Transaction> transactions) {
        this.transactionList = transactions;
    }
}
