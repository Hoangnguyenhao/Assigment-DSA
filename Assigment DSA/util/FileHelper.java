package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHelper {

    // Method to write text to a file
    public static void writeToFile(String fileName, String content) throws IOException {
        File file = new File(fileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
        }
    }

    // Method to read text from a file (optional)
    public static String readFromFile(String fileName) throws IOException {
        File file = new File(fileName);
        StringBuilder content = new StringBuilder();

        // Read file line by line (just as an example)
        try (java.util.Scanner scanner = new java.util.Scanner(file)) {
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine()).append("\n");
            }
        }

        return content.toString();
    }
}
