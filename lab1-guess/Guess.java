//Gavin Stuart 4/12/21
//CS145
//Lab 1

//This program is a guessing game. It is prompts the user for a 
//guess between 1 and an arbitrary number. The program then guides 
//the user toward a specific number that has been chosen automatically.  

import java.util.*; //import the scanner lib

//main (only) class
public class Guess {

    // main
    public static void main(String[] args) {

        // range of possible answers
        int guessRange = 100;

        // define a scanner
        Scanner console = new Scanner(System.in);

        // define a random number generator
        Random rand = new Random();

        // initalize values
        double totalGuesses = 0;
        int totalGames = 0;
        double gameAvgGuesses = 0;
        int bestGame = 0;
        String doContinue = null;

        // explain the game to the user
        explainGame(guessRange);

        // play at least one game
        boolean newGame = true;

        // first game?
        boolean firstGame = true;

        // while the user wants a new game, do the following
        do {

            totalGames++;

            // call the game method
            int gameGuesses = startGame(console, rand, guessRange);

            // did we set a record?
            if (bestGame > gameGuesses || firstGame) {
                bestGame = gameGuesses;
                firstGame = false;
            }

            // calculate the stats
            totalGuesses += gameGuesses;

            System.out.print("Do you want to play again? ");

            // ask the user whether they want to play another game
            try {
                doContinue = console.next().substring(0, 1).toUpperCase();
                if (!doContinue.equals("Y") && !doContinue.equals("N")) {
                    // we need y/n, send to catch
                    throw new Exception();
                }
            } catch (Exception e) {
                do {
                    System.out.println("Please enter a yes or no!\nDo you want to play again? yes/no");
                    doContinue = console.next().substring(0, 1).toUpperCase();
                } while (!doContinue.equals("Y") && !doContinue.equals("N"));
            }

            // if the user does not want to keep playing, break the loop
            if (doContinue.equals("N")) {
                newGame = false;
            }

        } while (newGame);

        System.out.println();
        gameAvgGuesses = (double) totalGuesses / totalGames;

        // print out the session stats
        sessionStat(totalGames, totalGuesses, gameAvgGuesses, bestGame);

    }

    // explains the game to the user
    public static void explainGame(int guessRange) {
        System.out.printf("This program allows you to play a guessing game.\n"
                + "I will think of a number between 1 and\n%d and will allow you to guess until\n"
                + "you get it.  For each guess, I will tell you \nwhether the "
                + "right answer is higher or lower \nthan your guess.\n", guessRange);
    }

    // This program is a guessing game. It is prompts the user for a guess between 1
    // and a arbitrary number. The program then guides the user toward a specific
    // number that has been chosen automatically.
    public static int startGame(Scanner console, Random rand, int guessRange) {

        // define the answer and ask the user for a guess
        // we need to add 1 to the random number generated
        // to get the correct range (1 -> guessRange)
        int answer = rand.nextInt(guessRange) + 1;

        // pop a new line, ask the user for a guess
        System.out.println();
        System.out.printf("I'm thinking of a number between 1 and %d...\nYour guess? ", guessRange);
        int userInput = console.nextInt();
        int guesses = 0;

        // if the user guesses correctly, print the following
        if (answer == userInput) {
            System.out.println("You got it right in 1 guess");
            guesses++;

        } else { // if the user is not lucky, do this

            do {
                // guide the user toward the correct answer
                if (answer > userInput) {
                    System.out.print("It's higher.\nYour guess? ");
                    userInput = console.nextInt();
                    guesses++;
                } else {
                    System.out.print("It's lower.\nYour guess? ");
                    userInput = console.nextInt();
                    guesses++;
                }
            } while (userInput != answer);

            guesses++;
            System.out.printf("You got it right in %d guesses\n", guesses);
        }

        // return the number guesses for stat processing
        return guesses;
    }

    // print out the results using printf
    public static void sessionStat(int totalGames, double totalGuesses, double gameAvgGuesses, int bestGame) {
        System.out.println("Overall results:");
        System.out.printf("\ttotal games   = %d\n", totalGames);
        System.out.printf("\ttotal guesses = %.0f\n", totalGuesses);
        System.out.printf("\tguesses/game  = %.1f\n", gameAvgGuesses);
        System.out.printf("\tbest game     = %d", bestGame);
    }

}