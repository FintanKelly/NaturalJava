package language;

/**
 * This class will contain methods that turn basic boolean algebra into natural
 * language methods.
 *
 * @author Harmtouch
 */
public final class BooleanLanguage {

    /**
     * Default constructor Not necessary to include anything here at the moment.
     */
    public BooleanLanguage() {

    }

    /**
     * Receives some amount of boolean statements to check and see if all of
     * them are true or not.
     *
     * Ex: checkForTrue(1 == 1, 2 == 1);
     *
     * @param statements - The set of statements that will be checked
     * @return - True if all of the statements are true and false if any of the
     * statements are false
     */
    public static boolean checkForTrue(boolean... statements) {
        for (boolean statement : statements) {
            if (!statement) {
                return false;
            }
        }

        return true;
    }

    /**
     * Receives some amount of boolean statements to check and see if they are
     * all false.
     *
     * Ex: checkForFalse(1==2, 2==2);
     *
     * @param statements - The set of statements that will be checked
     * @return - True if all of the statements are false and false if any of the
     * statements are true
     */
    public static boolean checkForFalse(boolean... statements) {
        for (boolean statement : statements) {
            if (statement) {
                return false;
            }
        }

        return true;
    }

    /**
     * Synonym method for checking to see if all included boolean statements are
     * true.
     *
     * Ex: and(1 == 1, 2 == 1);
     *
     * @param statements - The set of statements that will be checked
     * @return - True if all of the statements are true and false if any of the
     * statements are false
     */
    public static boolean and(boolean... statements) {
        return checkForTrue(statements);
    }

    /**
     * Synonym method for checking to see if any included boolean statements are
     * true.
     *
     * Ex: or(1 == 1, 2 == 1);
     *
     * @param statements - The set of all statements that will be checked
     * @return - True if any of the statements are true and false if all of the
     * statements are false
     */
    public static boolean or(boolean... statements) {
        for (boolean statement : statements) {
            if (statement) {
                return true;
            }
        }

        return false;
    }
}
