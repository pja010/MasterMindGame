package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Implementation of code sequence for MasterMind game.
 * The code sequence consists of 4 "code pegs" represented by integers between 1-6.
 * The sequence is randomly generated by the program.
 */
public class CodeSequence {
    private final int codeLength = 4;
    private int[] codeSequence = new int[codeLength];
    private Random rand = new Random();
    private final int upperBound = 6;

    /**
     * Generate random integer sequence.
     * Sequence length and range of random numbers is pre-specified in fields.
     */
    public void setCodeSequence() {
        for (int i = 0; i < codeSequence.length; ++i) {
            codeSequence[i] = rand.nextInt(upperBound) + 1;
        }
    }

    public int valueAt(int index) {
        return codeSequence[index];
    }

    public boolean contains(int value) {
        for (int i = 0; i < codeSequence.length; ++i) {
            if (codeSequence[i] == value) {
                return true;
            }

        }
        return false;
    }

    @Override
    public String toString() {
//        return "CodeSequence is " + Arrays.toString(codeSequence);
        String s = "";
        for (int i = 0; i < codeSequence.length; i++) {
            s += codeSequence[i];
        }
        return s;
    }

//    public static void main(String[] args) {
//        CodeSequence c1 = new CodeSequence();
//        c1.setCodeSequence();
//        System.out.println(c1);
//        System.out.println(c1.contains(1));
//        System.out.println(c1.valueAt(0));
//        System.out.println(c1.toString());
//    }
}
