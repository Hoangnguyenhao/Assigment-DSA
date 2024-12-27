package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Settings;

public class SettingsController {

    @FXML
    private TextField monthlyBudgetField;  // TextField to input the monthly budget

    private Settings settings = new Settings();  // Settings model to store the configuration

    public SettingsController(TextField monthlyBudgetField) {
        this.monthlyBudgetField = monthlyBudgetField;
    }

    // Method to handle saving settings
    public void handleSaveSettings(ActionEvent actionEvent) {
        try {
            // Retrieve the value from the TextField and convert it to a number
            double monthlyBudget = Double.parseDouble(monthlyBudgetField.getText());

            // Save the information in the Settings model
            settings.setMonthlyBudget(monthlyBudget);

            // Display success message
            showMessage("Settings saved successfully!", Alert.AlertType.INFORMATION);
        } catch (NumberFormatException e) {
            // If the user inputs an invalid number
            showMessage("Please enter a valid number for the monthly budget.", Alert.AlertType.ERROR);
        }
    }

    // Method to display messages to the user
    private void showMessage(String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(type.toString());
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Optionally, you can add a method to load settings from a file or database, for example:
    public void loadSettings() {
        // Assuming you have a method to load settings from a database
        monthlyBudgetField.setText(String.valueOf(settings.getMonthlyBudget()));
    }
}
