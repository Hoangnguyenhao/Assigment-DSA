package util;

public class InputValidator {

    // Check if the input string is a valid positive number
    public static boolean isValidNumber(String input) {
        try {
            Double.parseDouble(input);
            return true;  // Valid number
        } catch (NumberFormatException e) {
            return false;  // Invalid number
        }
    }

    // Check if the input string is a valid non-empty string
    public static boolean isValidString(String input) {
        return input != null && !input.trim().isEmpty();
    }
}
