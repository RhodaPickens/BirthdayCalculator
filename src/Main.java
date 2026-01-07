import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        int year = today.getYear();
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Welcome to the Magical Birthday Calculator!%n%n");

        // Get birthday from user and format into LocalDate
        System.out.println("What's your birthday? (mm-dd-yyyy)");
        System.out.print("> ");
        String birthdayUser = scanner.nextLine();
        scanner.close();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDate birthday = LocalDate.parse(birthdayUser, formatter);

        // Give original day of birth
        System.out.println("That means you were born on a " + birthday.getDayOfWeek());
        System.out.println();

        // Put together date of birthday this year
        LocalDate birthdayCurrentYear = LocalDate.of(year, birthday.getMonth(), birthday.getDayOfMonth());

        // Check if birthday has already passed this year
        if(birthdayCurrentYear.isBefore(today)) {
            birthdayCurrentYear = birthdayCurrentYear.plusYears(1);
        }

        // Tell user the day it falls on this year
        System.out.println("Your next birthday falls on a " + birthdayCurrentYear.getDayOfWeek());
        System.out.println();

        // Calculate days till next birthday
        long diffInDays = ChronoUnit.DAYS.between(today, birthdayCurrentYear);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        System.out.println("Since today is " + today.format(outputFormatter) + ", there's only " + diffInDays + " days until your next birthday!");
        System.out.println();
        long diffInYears = ChronoUnit.YEARS.between(birthday, birthdayCurrentYear);
        System.out.println("I bet you're excited to be turning " + diffInYears + " :)");
    }
}