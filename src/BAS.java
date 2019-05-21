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
}
