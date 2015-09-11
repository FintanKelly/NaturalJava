package language;

import static language.BooleanLanguage.*;

/**
 *
 * @author Harmtouch
 */
public class BooleanPractical {
    public static void main(String[] args) {
        System.out.println(checkForTrue(1 == 1, or(1 == 1, 2 == 1)));
    }
}
