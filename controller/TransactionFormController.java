package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Transaction;
import java.util.ArrayList;

public class TransactionFormController {

    @FXML
    private TextField amountField;        // Field to enter the amount of the transaction
    @FXML
    private ComboBox<String> typeComboBox; // ComboBox for selecting income or expense
    @FXML
    private ComboBox<String> categoryComboBox; // ComboBox for selecting category (e.g., groceries, bills)
    @FXML
    private DatePicker datePicker;        // DatePicker for selecting the transaction date

    private ArrayList<Transaction> transactionList = new ArrayList<>(); // List to store transactions temporarily

    // Handle form submission to add transaction
    public void handleSubmitTransaction(ActionEvent actionEvent) {
        try {
            // Retrieve the input data from the form
            String amountText = amountField.getText();   // Get the amount entered
            String type = typeComboBox.getValue();       // Get the selected type (Income/Expense)
            String category = categoryComboBox.getValue(); // Get the selected category
            String date = datePicker.getValue().toString(); // Get the selected date

            // Validate input fields
            if (amountText.isEmpty() || type == null || category == null || date == null) {
                showError("All fields must be filled.");
                return;
            }

            // Validate the amount input (must be a number)
            double amount;
            try {
                amount = Double.parseDouble(amountText);
            } catch (NumberFormatException e) {
                showError("Please enter a valid number for the amount.");
                return;
            }

            // Create a new transaction object
            Transaction newTransaction = new Transaction(amount, type, category, date);

            // Add the new transaction to the transaction list (or save to database/file)
            transactionList.add(newTransaction);

            // Provide feedback to the user
            showSuccess("Transaction added successfully.");
            clearFields(); // Clear the input fields for the next transaction

        } catch (Exception e) {
            showError("An error occurred while adding the transaction.");
            e.printStackTrace();
        }
    }

    // Clear the input fields after adding a transaction
    private void clearFields() {
        amountField.clear();
        typeComboBox.setValue(null);
        categoryComboBox.setValue(null);
        datePicker.setValue(null);
    }

    // Show a success message in a dialog box
    private void showSuccess(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Show an error message in a dialog box
    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
