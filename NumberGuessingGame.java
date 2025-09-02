package OASIS_INFOBYTE;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame
 {

    public static void main(String[] args)
     {
       
        Scanner scanner = new Scanner(System.in);
       
        Random random = new Random();

        
        final int MIN_RANGE = 1;
        final int MAX_RANGE = 100;
        final int MAX_ATTEMPTS = 5;

        
        int totalRoundsWon = 0;
        int totalAttemptsMade = 0;
        boolean playAgain;

        
        do {
           
            int randomNumber = random.nextInt(MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("----------------------------------------");
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have generated a number between " + MIN_RANGE + " and " + MAX_RANGE + ".");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess it.");

            
            while (attempts < MAX_ATTEMPTS) {
                System.out.print("\nEnter your guess (Attempt " + (attempts + 1) + "/" + MAX_ATTEMPTS + "): ");
                
                
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a number.");
                    scanner.next(); 
                    continue;
                }

                int userGuess = scanner.nextInt();
                attempts++;
                totalAttemptsMade++;

                
                if (userGuess == randomNumber) {
                    System.out.println("🎉 Congratulations! You guessed the correct number!");
                    System.out.println("You took " + attempts + " attempts this round.");
                    totalRoundsWon++;
                    hasGuessedCorrectly = true;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Your guess is too low. Try again.");
                } else {
                    System.out.println("Your guess is too high. Try again.");
                }
            }

            
            if (!hasGuessedCorrectly) {
                System.out.println("\n🚫 You've run out of attempts!");
                System.out.println("The correct number was: " + randomNumber);
            }

            
            System.out.print("\nWould you like to play another round? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");

        } while (playAgain);

       
        System.out.println("\n----------------------------------------");
        System.out.println("Thank you for playing!");
        System.out.println("Your final score:" + totalRoundsWon);
        System.out.println("Rounds Won: " + totalRoundsWon);
        System.out.println("Total Attempts Made: " + totalAttemptsMade);
        System.out.println("----------------------------------------");

        
        scanner.close();
    }
}



