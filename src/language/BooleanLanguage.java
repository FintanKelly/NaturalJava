package language;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
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
     * Synonym method for checking to see if any included boolean statements are
     * true.
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
     * Takes a list of unknown objects and compares them for identity. The
     * objects will be transferred to an IdentityHashMap and then checked to see
     * if the previous value is identical to the next added value. If this ever
     * not true, then it means that there was a value that was not identical.
     *
     * Ex: compareIdentity("test", "test");
     *
     * @param objects - The set of unknown objects
     * @return - True if all values are identical and false if any of them are
     * not
     */
    public static boolean compareIdentity(Object... objects) {
        Map<Class<?>, Object> objectMap = new IdentityHashMap<>();

        for (Object object : objects) {
            if (objectMap.isEmpty()) {
                objectMap.put(object.getClass(), object);
            } else {
                Object oldValue = objectMap.get(object.getClass());
                objectMap.put(object.getClass(), object);

                if (oldValue != objectMap.get(object.getClass())) {
                    return false;
                } else {
                    return true;
                }
            }
        }

        return true;
    }

    /**
     * Takes a list of unknown objects and compares them for equality. This
     * method will -ONLY- work if the user has overridden the equals and
     * hashCode methods to check for the right contents. The last parameter
     * -MUST- be a boolean indicating if the objects the user is comparing are
     * user created or not.
     *
     * Ex:
     *
     * @param objects - The set of unknown objects
     * @return - True if the contents of all the objects are equal or false if
     * they are not.
     */
    public static boolean compareEquality(Object... objects) {
        Method hashMethod = null;
        Method equalsMethod = null;
        Boolean userCreated = (boolean) objects[objects.length - 1];

        if (userCreated) {
            try {
                hashMethod = objects.getClass().getMethod("hashCode");
                equalsMethod = objects.getClass().getMethod("equals");
            } catch (NoSuchMethodException ex) {
                System.out.println("Please override the hashCode and equals method for your classes first!");
            }
        } else if (!userCreated.getClass().equals(Boolean.class)) {
            System.out.println("Please add a boolean indicating if the objects belongs to a user created classes.");
        } else {
            Set<Object> objectSet = new HashSet<>(Arrays.asList(objects));
            objectSet.remove(userCreated);

            return objectSet.size() == 1;
        }

        if (overridesMethod(hashMethod, Object.class) && (overridesMethod(equalsMethod, Object.class))) {
            Set<Object> objectSet = new HashSet<>(Arrays.asList(objects));

            return objectSet.size() == 1;
        }

        return false;
    }

    /**
     * Checks to see if a given method belongs to the given class or not.
     *
     * @param method - The method that is being checked
     * @param mainClass - The class that is being checked for ownership of the
     * method
     * @return True if the method does not belong to the class and false if it
     * does
     */
    public static boolean overridesMethod(Method method, Class<?> mainClass) {
        return mainClass == method.getDeclaringClass();
    }
}
