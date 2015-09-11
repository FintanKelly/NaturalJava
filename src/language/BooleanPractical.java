package language;

import static language.BooleanLanguage.*;

/**
 *
 * @author Harmtouch
 */
public class BooleanPractical {

    public static void main(String[] args) {
        if (checkForTrue(1 == 1, or(1 == 2, 2 == 2))) {
            System.out.println("Success!");
        } else {
            System.out.println("Failure!");
        }
    }
}
