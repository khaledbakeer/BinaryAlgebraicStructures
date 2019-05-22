/*
 * MIT License
 *
 * Copyright (c) 2019.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package de.khaled.BinaryAlgebraicStructures;

/**
 * Binary Algebraic Structures:
 * ----------------------------
 */
public class BAS {

    /**
     * Don't let anyone instantiate this class.
     */
    private BAS() {

    }

    /**
     * bitOf:
     * ------
     *
     * @param input char '1' or '0'.
     * @return boolean value converted from char.
     */
    private static boolean bitOf(char input) {
        return (input == '1');
    }

    /**
     * charOf:
     * -------
     *
     * @param input boolean
     * @return char '1' or '0'.
     */
    private static char charOf(boolean input) {
        return (input) ? '1' : '0';
    }


    /**
     * Add Operator As Boolean:
     * ------------------------
     * <p>
     * add several binary values from type char, and return boolean value.
     *
     * @param chars like '1', '0', '0', '1', ... ext.
     * @return boolean
     */
    private static boolean AdditionOperatorAsBoolean(char... chars) {
        boolean tmp = false;
        for (char x : chars) {
            tmp = tmp ^ bitOf(x);
        }
        return tmp;
    }

    /**
     * Addition Operator As Char:
     * --------------------------
     * <p>
     * add several binary values from type char, and return also char value.
     *
     * @param chars like '1', '0', '0', '1', ... ext.
     * @return char also.
     */
    private static char AdditionOperatorAsChar(char... chars) {
        boolean tmp = false;  // Neutral element
        for (char x : chars) {
            tmp = tmp ^ bitOf(x);
        }
        return (tmp) ? '1' : '0';
    }

    /**
     * MultiplicationOperatorAsChar
     *
     * @param chars like '1', '0', '0', '1', ... ext.
     * @return char also.
     */
    private static char MultiplicationOperatorAsChar(char... chars) {
        boolean tmp = true; // Neutral element
        for (char x : chars) {
            tmp = tmp && bitOf(x);
        }
        return (tmp) ? '1' : '0';
    }

    /**
     * get Max Length Of Strings:
     * --------------------------
     *
     * @param args Strings
     * @return max length of all Strings.
     */
    private static int getMaxLengthOfStrings(String... args) {
        int max = 0;
        for (String x : args) {
            if (x.length() > max) max = x.length();
        }
        return max;
    }


    /**
     * get Modified Array:
     * -------------------
     * <p>
     * convert old array with lower counts of binary digits to an array with the same value,
     * but with zeros at the beginning.
     * <p>
     * example: (10, "101001") -> "0000101001".
     *
     * @param max int new max index of the new array.
     * @param old array to be modified, "101001".
     * @return new modified array, "0000101001".
     */
    private static char[] getModifiedArray(int max, char[] old) {
        char[] newArray = new char[max];

        if (max > old.length) {
            for (int i = (max - 1); i >= 0; i--) {
                int x = i - (max - old.length);
                if (x < 0) newArray[i] = '0';
                else newArray[i] = old[x];
            }
        }

        return newArray;
    }

    /**
     * get Modified Arrays:
     * --------------------
     * <p>
     * Convert string arguments with different string lengths to be them length uniq.
     * <p>
     * example: ("101011", "10", "001") -> String[] = {"101011", "000010", "000001"}
     *
     * @param args Strings
     * @return String[] with uniq string length
     */
    private static String[] getModifiedArrays(String... args) {
        int max = getMaxLengthOfStrings(args);
        for (int i = 0; i < args.length; i++) {
            if (args[i].length() < max) {
                char[] temp = new char[max];
                for (int j = 0; j < temp.length; j++) {
                    temp[j] = getModifiedArray(max, args[i].toCharArray())[j];
                }
                args[i] = String.valueOf(temp);
            }
        }
        return args;
    }

    /**
     * check Binary Validate:
     * ----------------------
     *
     * @param strins strings.
     */
    private static void checkBinaryValidate(String... strins) {
        if (strins.length <= 0) throw new IllegalArgumentException("it should be at least one argument.");
        for (String x : strins) {
            if (x.length() == 0) throw new IllegalArgumentException("Your entries cannot be empty Strings!");
            for (int i = 0; i < x.length(); i++) {
                char tmp = x.toCharArray()[i];
                if (tmp != '0' && tmp != '1')
                    throw new IllegalArgumentException("Please correct your entries, only binaries will be accepted!");
            }
        }
    }

    /**
     * Add:
     * ----
     * <p>
     * add several Strings from type of binary digits using Algebraic Structures (Addition Operator).
     * <p>
     * + | 0 | 1
     * ----------
     * 0 | 0 | 1
     * ----------
     * 1 | 1 | 0
     *
     * @param strings Strings from type "101", "100", "111", ... ext.
     * @return String from type "110".
     */
    public static String Add(String... strings) {
        checkBinaryValidate(strings);
        int max = getMaxLengthOfStrings(strings);
        String[] args = getModifiedArrays(strings);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < max; i++) {
            char[] row = new char[args.length];
            for (int j = 0; j < args.length; j++) {
                if (args[j].length() == max) row[j] = args[j].toCharArray()[i];
            }
            sb.append(AdditionOperatorAsChar(row));
        }
        return sb.toString();
    }

    /**
     * Mult:
     * -----
     * <p>
     * Multiplicat several Strings from type of binary digits using Algebraic Structures (Multiplication Operator).
     * <p>
     * * | 0 | 1
     * ----------
     * 0 | 0 | 0
     * ----------
     * 1 | 0 | 1
     *
     * @param strings Strings from type "101", "100", "111", ... ext.
     * @return String from type "100".
     */
    public static String Mult(String... strings) {
        checkBinaryValidate(strings);
        int max = getMaxLengthOfStrings(strings);
        String[] args = getModifiedArrays(strings);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < max; i++) {
            char[] row = new char[args.length];
            for (int j = 0; j < args.length; j++) {
                if (args[j].length() == max) row[j] = args[j].toCharArray()[i];
            }
            sb.append(MultiplicationOperatorAsChar(row));
        }
        return sb.toString();
    }

}
