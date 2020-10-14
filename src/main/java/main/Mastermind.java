package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Single player implementation of mastermind
 * where computer generates marble code sequence
 * and user is to guess the correct sequence.
 */
public class Mastermind {
    private final static int GuessesAllowed = 12;
    public int codePeg;
    public char scorePeg;
    private String scorePegString = "";
    public String userGuessSequence = null;
    private CodeSequence solutionCode;

    /**
     * Main method that starts new game.
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String userChoice;

        startNewGame();
        System.out.print("Would you like to play the game again? [Y/N]: ");
        userChoice = scnr.nextLine();
        while (userChoice.contains("Y") || userChoice.contains("y")) {
            startNewGame();
        }
        System.out.println("Goodbye!");
    }

    private static void startNewGame() {
        CodeSequence solutionCode = new CodeSequence();
        int guessesLeft = 12;
        int numberOfGuesses = 0;
        String scorePegString = "";
        Scanner scnr = new Scanner((System.in));
        String userGuessSequence;
        solutionCode.setCodeSequence();
//        System.out.println(solutionCode);

        System.out.println("Guess my code, using numbers between 1-6. You have " + GuessesAllowed + " guesses.");
        while (numberOfGuesses < GuessesAllowed) {
            System.out.print("Guess " + numberOfGuesses + ": ");
            userGuessSequence = scnr.nextLine().strip();

            scorePegString = comparePegs(userGuessSequence, scorePegString, solutionCode);
            numberOfGuesses += 1;
            guessesLeft -= 1;

            System.out.print(userGuessSequence + " --> " + scorePegString + "    ");
            scorePegString = checkIfWin(scorePegString, numberOfGuesses, guessesLeft);
            if (scorePegString == null) {
                break;
            }
        }
    }

    /**
     * Compare player's pegs with the correct code pegs.
     * "*" means correct peg and correct position,
     * "+" means correct peg, wrong position,
     * "-" means wrong peg, wrong position
     *
     * @param userGuessSequence
     * @param scorePegString
     * @param solutionCode
     * @return scorePegString - String representing 4 score pegs
     */
    private static String comparePegs(String userGuessSequence, String scorePegString, CodeSequence solutionCode) {
        int codePeg;
        for (int i = 0; i < 4; ++i) {
            codePeg = Integer.parseInt(userGuessSequence.substring(i, i+1));
            if (codePeg == solutionCode.valueAt(i)) {
                scorePegString += "*";
            }
            else if (solutionCode.contains(codePeg)) {
                scorePegString += "+";
            }
            else {
                scorePegString += "-";
            }
        }
        return scorePegString;
    }

    /**
     * Check if player's code is correct or not and hence determine the game status.
     * @param scorePegString
     * @param numberOfGuesses
     * @param guessesLeft
     * @return
     */
    private static String checkIfWin(String scorePegString, int numberOfGuesses, int guessesLeft) {
        if (scorePegString.equals("****")) {
            System.out.println("YOU WON! You guessed the code in " + numberOfGuesses + " moves.");
            return null;
        }
        else {
            System.out.println("Try again. You have " + guessesLeft + " guesses left." );
            scorePegString = "";
        }
        return scorePegString;
    }
}
