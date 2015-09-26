package language;

import static language.BooleanLanguage.*;

/**
 * This is a small class that will contain examples of how the methods inside
 * BooleanLanguage can be used.
 *
 * @author Harmtouch
 */
public class BooleanPractical {

    /**
     * Main executed method.
     *
     * @param args - Command line arguments, not being used.
     */
    public static void main(String[] args) {
        if (checkForTrue(1 == 1, or(1 == 2, 2 == 2), and(not(compareEquality(false, "test", "Test"))))) {
            System.out.println("Success!");
        } else {
            System.out.println("Failure!");
        }
    }
}
