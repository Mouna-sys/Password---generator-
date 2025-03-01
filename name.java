# Password---generator-
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter password length: ");
        int length = scanner.nextInt();

        System.out.print("Include alphabets? (true/false): ");
        boolean includeAlphabets = scanner.nextBoolean();

        System.out.print("Include numbers? (true/false): ");
        boolean includeNumbers = scanner.nextBoolean();

        System.out.print("Include symbols? (true/false): ");
        boolean includeSymbols = scanner.nextBoolean();

        String password = generatePassword(length, includeAlphabets, includeNumbers, includeSymbols);
        System.out.println("Generated password: " + password);

        scanner.close();
    }

    public static String generatePassword(int length, boolean includeAlphabets, boolean includeNumbers, boolean includeSymbols) {
        String alphabets = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*()-_+=<>?/{}[]|";

        StringBuilder allowedChars = new StringBuilder();
        if (includeAlphabets) {
            allowedChars.append(alphabets);
        }
        if (includeNumbers) {
            allowedChars.append(numbers);
        }
        if (includeSymbols) {
            allowedChars.append(symbols);
        }

        if (allowedChars.length() == 0) {
            return ""; // No characters allowed
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allowedChars.length());
            password.append(allowedChars.charAt(randomIndex));
        }

        return password.toString();
    }
}
