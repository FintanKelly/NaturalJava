package language;

/**
 * This class will contain methods that turn basic boolean algebra into natural
 * language methods.
 *
 * @author Harmtouch
 */
public class BooleanL {

    /**
     * Default constructor Not necessary to include anything here at the moment.
     */
    public BooleanL() {

    }

    /**
     * Receives some amount of boolean statements to check and see if there is
     * at least one true statements.
     * 
     * Ex: checkFor(1 == 1, 2 == 1);
     *
     * @param statements - The set of statements that will be searched through
     * @return True or False depending on if there is at least one true
     * statement or not
     */
    public boolean checkFor(boolean... statements) {
        for (boolean object : statements) {
            if (object) {
                return true;
            } else {
                System.out.println("You must use statements that can be assessed as true or false.");
            }
        }

        return false;
    }
}
