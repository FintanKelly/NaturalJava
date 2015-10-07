package language;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This class will contain methods that turn basic boolean algebra into natural
 * language methods.
 *
 * @author Harmtouch
 */
public final class BooleanLanguage {

    /**
     * Default constructor, not necessary to include anything here at the
     * moment.
     */
    public BooleanLanguage() {

    }

    /**
     * Receives some amount of boolean statements to check and see if all of
     * them are true or not.
     *
     * Ex: checkForTrue(1 == 1, 2 == 1);
     *
     * @param statements - The set of boolean algebra statements that will be
     * checked
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
     * @param statements - The set of boolean algebra statements that will be
     * checked
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
     * @param statements - The set of boolean algebra statements that will be
     * checked
     * @return - True if all of the statements are true and false if any of the
     * statements are false
     */
    public static boolean and(boolean... statements) {
        return checkForTrue(statements);
    }

    /**
     * Checks to see if any included boolean statements are true.
     *
     * Ex: or(1 == 1, 2 == 1);
     *
     * @param statements - The set of boolean algebra statements that will be
     * checked
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

    /**
     * Synonym method to check if the included boolean statements are all false.
     *
     * Ex: not(1 == 1, 2 == 1);
     *
     * @param statements - The set of logic statements to check
     * @return - True if all of the statements are false and false if any of the
     * statements are true
     */
    public static boolean not(boolean... statements) {
        return checkForFalse(statements);
    }

    /**
     * Takes a list of unknown objects and compares them for identity. This can
     * be accomplished simply by looping through the objects and comparing them
     * with '=='.
     *
     * Ex: compareIdentity("test", "test");
     *
     * @param objects - The set of unknown objects
     * @return - True if all values are identical and false if any of them are
     * not
     */
    public static boolean compareIdentity(Object... objects) {
        for (int i = 1; i < objects.length; i++) {
            if (objects[i] != objects[i - 1]) {
                return false;
            }
        }

        return true;

        /**
         * Example of using IdentityHashMap:
         *
         * Map<Class<?>, Object> objectMap = new IdentityHashMap<>();
         *
         * for (Object object : objects) { if (objectMap.isEmpty()) {
         * objectMap.put(object.getClass(), object); } else { Object oldValue =
         * objectMap.get(object.getClass()); objectMap.put(object.getClass(),
         * object);
         *
         * if (oldValue != objectMap.get(object.getClass())) { return false; } }
         * }
         *
         * return true;
         *
         *
         */
    }

    /**
     * Takes a list of unknown objects and compares them for equality. This
     * method will assume that the user has overridden the hashCode and equals
     * method where necessary.
     *
     * Ex: compareIdentity("test", "test");
     *
     * @param objects - The set of unknown objects
     * @return - True if the contents of all the objects are equal or false if
     * they are not.
     */
    public static boolean compareEquality(Object... objects) {
        Set<Object> objectSet = new HashSet<>(Arrays.asList(objects));

        return objectSet.size() == 1;
    }
}
