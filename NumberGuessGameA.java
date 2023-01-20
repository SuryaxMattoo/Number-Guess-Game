//Surya Mattoo - 1/20/23
//Number Guess Game©

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class NumberGuessGameA // Name of the public class
{
    public static void main(final String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Set the range for the game by inputting two different numbers.");
        int min = 0;
        if (sc.hasNextInt()){
            min = sc.nextInt();
        } else {
            sc.next(); // discard
            System.out.println("Hey I'm sorry but you did not choose the minimum as an integer. I will set the minimum to zero for you");
        } //If we set the number to something that is not an int -> Discard the character and set the initial value to zero
        
        if (sc.hasNextInt()){
            
        }
        int max = sc.nextInt();
        int numTries = 0;
        // Setting the number of tries to zero
        // Using sc.nextInt and scanner for the error checking portion described below


            


     
        ArrayList<Integer> names = new ArrayList<Integer>();
        // Making it an empty array so that it does not output the same answer more than
        // once

        int guess = 0;
        final Random rand = new Random();

        final int randNumber = rand.nextInt(min, max + 1);
        System.out.println("I am thinking of a number from " + min + " to " + max + ". Can you guess it?"); // Main question

        // Main while loop
        while (guess != randNumber) {
            guess = errorCheck(sc, min, max);
            ++numTries;
            if (names.contains(guess)) {
                System.out.println("You've already guessed this. Try again");
                // Piece of code that states whether we have guessed the previous number and
                // will tell them to repeat
            }
            if (guess > randNumber) {
                System.out.println("Nope! Go lower.");
                // If we pick the number higher then the selected one then it tells us to go
                // lower
                names.add(guess);
                // Adds one attempt to the guesses

            } else {
                if (guess >= randNumber) {
                    continue;
                }
                System.out.println("Nope! Go higher.");
                // If we select a number too low then we must pick a higher number
            }
            names.add(guess);
            // Adds one attempt to the guesses

        }
        System.out.println("You got it! It took you " + numTries + " tries to guess " + randNumber);
        // What happens if we choose the right number and adds the number of tries and
        // the random number that the computer selected
    }

    // Below is how I went about error checking
    public static int errorCheck(final Scanner sc, final int min, final int max) {
        if (!sc.hasNextInt()) {
            System.out.println("This is not a number. Discarding this input");
            // If the input was not an integer then this would occur
            sc.next();
            // Calling function
            return errorCheck(sc, min, max);
            // Runs through the error checking functions defined above
        }
        // Below just says that if the input is a number then all we need to do is
        // continue runnign code and acknowledge that
        // it is a number
        final int input = sc.nextInt();
        System.out.println("This is a number");
        if (input > max || input < min) {
            System.out.println("Hey! this number is out of the range. Try again.");
            return errorCheck(sc, min, max);
            // Error checks to make sure that the number is within the boundaries set
            // earlier
        }
        return input;
    }
}
