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
    public int codePeg;
    public char scorePeg;




    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String userGuessSequence = null;
        String scorePegString = "";
        int codePeg;
        int numberOfGuesses = 0;
        int guessesLeft = 12;
        final int GuessesAllowed = 12;
        CodeSequence solutionCode = new CodeSequence();

        solutionCode.setCodeSequence();
        System.out.println(solutionCode);

        System.out.println("Guess my code, using numbers between 1-6. You have " + GuessesAllowed + " guesses.");
        while (numberOfGuesses < GuessesAllowed) {
            System.out.print("Guess " + numberOfGuesses + ": ");
            userGuessSequence = scnr.nextLine().strip();

            for (int i = 0; i < 4; ++i) {
                codePeg = Integer.parseInt(userGuessSequence.substring(i,i+1));
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
            numberOfGuesses += 1;
            guessesLeft -= 1;

            System.out.print(userGuessSequence + " --> " + scorePegString + "    ");
            if (scorePegString.equals("****") == true) {
                System.out.println("YOU WON! You guessed the code in " + numberOfGuesses + " moves.");
                break;
            }
            else {
                System.out.println("Try again. You have " + guessesLeft + " guesses left." );
                scorePegString = "";
            }
        }
    }

    ;




}
