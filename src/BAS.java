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
     *
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
}
