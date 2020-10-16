/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2020
 * Instructor: Prof. Brian King
 *
 * Name: Guillermo Torres and Per Astrom
 * Section: 02/01
 * Date: 10/15/2020
 * Time: 3:29 PM
 *
 * Project: csci205_hw
 * Package: main
 * Class: Mastermind
 *
 * Description:
 * Currently a single player implementation
 * of mastermind where computer generates
 * marble code sequence and user is to
 * guess the correct sequence.
 * ****************************************
 */
package main;

import java.util.Scanner;
import java.util.Stack;

/**
 * A class that creates and runs a Mastermind game
 */
public class Mastermind {

    private final static int GUESSES_ALLOWED = 12;
    private static int numberOfGuesses = 0;
    private static int guessesLeft = 12;
    private static int codePeg;
    private static String scorePegString = "";
    private static String userGuessSequence = null;
    private static CodeSequence solutionCode;
    private static String userChoice = "y";
    private static Scanner scnr;

    /**
     * Main method that sets up the Mastermind game.
     * Initially starts a new round. When the round is over,
     * asks if player wishes to play another round and continues
     * to do this until user choose to quit.
     */
    public static void main(String[] args) {
        scnr = new Scanner(System.in);
        solutionCode = new CodeSequence();

        while (userChoice.contains("Y") || userChoice.contains("y")) {
            solutionCode.setCodeSequence();
            scorePegString = "";
            numberOfGuesses = 0;
            guessesLeft = 12;
            startNewGame();
            System.out.print("Would you like to play the game again? [Y/N]: ");
            userChoice = scnr.nextLine();
        }
        System.out.println("Goodbye!");
    }

    /**
     * Start new round of Mastermind
     */
    private static void startNewGame() {
        scnr = new Scanner((System.in));
        //System.out.println(solutionCode);

        System.out.println("Guess my code, using numbers between 1-6. You have " + GUESSES_ALLOWED + " guesses.");
        while (numberOfGuesses < GUESSES_ALLOWED) {
            try {
                System.out.print("Guess " + numberOfGuesses + ": ");
                userGuessSequence = scnr.nextLine().strip();

                scorePegString = comparePegs(userGuessSequence, solutionCode);
                numberOfGuesses += 1;
                guessesLeft -= 1;

                System.out.print(userGuessSequence + " --> " + scorePegString + "    ");
                scorePegString = checkIfWin(scorePegString);
                if (scorePegString == null) {
                    break;
                }
            } catch (StringIndexOutOfBoundsException | IncorrectStringLengthException e) {
                System.out.println("Guess is incomplete: expected 4 characters, but " + userGuessSequence.length()
                                    + " were entered. Please try again.");
                scnr.nextLine();
                continue;
            }
        }
    }

    /**
     * Compare player's pegs with the correct code pegs.
     * "*" means correct peg and correct position,
     * "+" means correct peg, wrong position,
     * "-" means wrong peg, wrong position
     *
     * @param userGuessSequence - A String representing player's guess
     * @param solutionCode - A String representing the correct code sequence
     * @return scorePegString - String representing 4 score pegs
     */
    private static String comparePegs(String userGuessSequence, CodeSequence solutionCode) throws IncorrectStringLengthException {
        Stack<String> numAstrix = new Stack<>();
        Stack<String> numPlus = new Stack<>();
        Stack<String> numMinus = new Stack<>();

        // Check that user's guess is not too long
        if (userGuessSequence.length() > 4) {
            throw new IncorrectStringLengthException("Guess is incomplete: expected 4 characters, but "
                    + userGuessSequence.length() + " were entered. Please try again.");
        }

        for (int i = 0; i < 4; ++i) {
            codePeg = Integer.parseInt(userGuessSequence.substring(i, i+1));
            if (codePeg == solutionCode.valueAt(i)) {
                numAstrix.push("*");
            }
            else if (solutionCode.contains(codePeg)) {
                numPlus.push("+");
            }
            else {
                numMinus.push("-");
            }
        }
        // add score pegs to list in appropriate order
        while (!numAstrix.isEmpty()) {
            scorePegString += numAstrix.pop();
        }
        while (!numPlus.isEmpty()) {
            scorePegString += numPlus.pop();
        }
        while (!numMinus.isEmpty()){
            scorePegString += numMinus.pop();
        }
        return scorePegString;
    }

    /**
     * Check if player's code is correct or not and hence determine the game status.
     * @param scorePegString - String with score based on user's guess.
     *                       Will be set to null if a Win is declared.
     * @return scorePegString
     */
    private static String checkIfWin(String scorePegString) {
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

