package main;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.charset.CoderMalfunctionError;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CodeSequenceTest {

    @BeforeEach
    void setUp() {
        CodeSequence code1 = new CodeSequence();

    }

    @AfterEach
    void tearDown() {
    }

    /**
     * A test method used to check if the setCodeSequence() method
     * is successfully creating a code solution for the game
     */
    @Test
    void setCodeSequence() {
        CodeSequence code1 = new CodeSequence();
        code1.setCodeSequence();
        // First test to determine the length is correct
        assertEquals(4, code1.getCodeSequence().length);

        CodeSequence code2 = new CodeSequence();
        code2.setCodeSequence();
        // Second test to determine the length is correct
        assertEquals(4, code2.getCodeSequence().length);
    }

    /**
     * A test method use to check if the contains() method
     * can correctly check if the number inputted by the
     * user is inside the code solution
     */
    @Test
    void contains() {
        //CodeSequence code1 = new CodeSequence();
        //code1.setCodeSequence();
    }
}