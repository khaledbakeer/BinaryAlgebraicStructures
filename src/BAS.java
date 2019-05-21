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

/**
 * Binary Algebraic Structures:
 * ----------------------------
 */
public class BAS {

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
        boolean tmp = false;
        for (char x : chars) {
            tmp = tmp ^ bitOf(x);
        }
        return (tmp) ? '1' : '0';
    }

    /**
     * Add:
     * ----
     * <p>
     * add several Strings from type of binary digits using Algebraic Structures (Addition Operator).
     *
     * @param args Strings from type "101", "100", "111", ... ext.
     * @return String from type "110".
     */
    public static String Add(String... args) {

        // TODO not all args have the same digit counts!
        // "10", "110" no error -> 11
        // "111", "11" -> Error: ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 2

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < args[0].length(); i++) {
            char[] row = new char[args.length];
            for (int j = 0; j < args.length; j++) {
                row[j] = args[j].toCharArray()[i];
            }
            sb.append(AdditionOperatorAsChar(row));
        }
        return sb.toString();
    }

    // TODO multiplication
}
