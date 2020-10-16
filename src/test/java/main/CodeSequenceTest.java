package main;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.charset.CoderMalfunctionError;

import static org.junit.jupiter.api.Assertions.*;

class CodeSequenceTest {

    @BeforeEach
    void setUp() {
        CodeSequence code1 = new CodeSequence();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void setCodeSequence() {
        CodeSequence code1 = new CodeSequence();
        code1.setCodeSequence();
        //
        assertEquals(4, code1.getCodeSequence().length);

        CodeSequence code2 = new CodeSequence();
        code2.setCodeSequence();
        assertEquals(4, code2.getCodeSequence().length);
    }

    //@Test
    //void valueAt() {
    //}

    @Test
    void contains() {
    }
}