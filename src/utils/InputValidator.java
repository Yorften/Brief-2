package src.utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public final class InputValidator {

    public static Scanner in = new Scanner(System.in).useDelimiter(System.lineSeparator());

    // Private constructor
    private InputValidator() {
    }

    public static int promptAndParseInt(String message, int min, int max) {
        do {
            try {
                System.out.print(message);
                int input = in.nextInt();
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.print("Please pick a choice between " + min + " and " + max + "...");
                    in.next();
                }
            } catch (Exception e) {
                System.out.print("Please pick a valid number...");
                in.next();
            }
        } while (true);
    }

    public static int promptAndParseInt(String message) {
        do {
            try {
                System.out.print(message);
                int input = in.nextInt();
                if (input > 0) {
                    return input;
                } else {
                    System.out.print("Please enter a non null number");
                    in.next();
                }
            } catch (Exception e) {
                System.out.print("Please pick a valid number...");
                in.next();
            }
        } while (true);
    }

    public static String promptAndParseString(String message) {
        do {
            try {
                System.out.print(message);
                String input = in.next();
                if (!input.trim().isEmpty()) {
                    return input;
                } else {
                    System.out.print("Please enter a valid string (no empty strings, spaces, ...)");
                    in.next();
                }
            } catch (Exception e) {
                System.out.print("Please enter a valid string");
                in.next();
            }
        } while (true);
    }

    public static LocalDate promptAndParseDate(String message) {
        while (true) {
            try {
                System.out.print(message);
                String dateString = in.next();

                return DateUtils.parseDate(dateString);
            } catch (DateTimeParseException e) {
                System.out.print("Invalid date format. Please enter the date in the format dd-MM-yyyy...");
                in.next();
            } catch (Exception e) {
                System.out.print(e.getMessage());
                in.next();
            }
        }
    }

}
