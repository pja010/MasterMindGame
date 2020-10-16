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
 * Class: IncorrectStringLengthException
 *
 * Description:
 * Exception class that handles inputs of
 * inappropriate length in Mastermind
 * program
 * ****************************************
 */

package main;

/**
 * Exception class that handles user inputs of incorrect length
 */
public class IncorrectStringLengthException extends Exception {
    public IncorrectStringLengthException(String errorMessage) {
        super(errorMessage);
    }
}
