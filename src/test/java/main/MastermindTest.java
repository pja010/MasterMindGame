package main;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MastermindTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void startNewGame() {

    }

    @Test
    void comparePegs() {
        String testGuess1 = "1234";
//        CodeSequence testSolution1 = ;
        int[] testSolution1 = new int[4];
        String testGuess2 = "5678";
        String testSolution2 ="4321";

//        comparePegs(testGuess1, testSolution1);
    }

    @Test
    void checkIfWin() {
        String pegs1 = "****";
//        checkIfWin(pegs1);
    }
}