package testing;

import language.UserClass;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * This will act as the test case for the UserClass class. Note: This class will
 * not explain the reasoning or logic behind functionality, all of that can be
 * found in the UserClass class itself.
 *
 * @author Harmtouch
 */
public class UserClassTest {

    /**
     * Variables that will be used for testing the class
     */
    UserClass user, user2;
    String name;
    int id;

    /**
     * Default constructor not necessary for testing right now
     */
    public UserClassTest() {

    }

    @Before
    /**
     * Set up all the necessary elements for each test case
     */
    public void setUp() {
        user = new UserClass("Bill", 1);
        name = "Bob";
        id = 2;
    }

    @Test
    /**
     * Test all 3 constructors
     */
    public void testConstructors() {
        user2 = new UserClass();
        assertTrue(user2.getName().equals(""));
        assertTrue(user2.getID() == -1);

        user2 = new UserClass(name);
        assertTrue(user2.getName().equals("Bob"));
        assertTrue(user2.getID() == -1);

        user2 = new UserClass(name, id);
        assertTrue(user2.getName().equals("Bob"));
        assertTrue(user2.getID() == 2);
    }

    @Test
    /**
     * Test the getName() and setName() methods
     */
    public void testNames() {
        assertTrue(user.getName().equals("Bill"));

        user.setName("Jake");
        assertTrue(user.getName().equals("Jake"));
    }

    @Test
    /**
     * Test the getID() and setID() methods
     */
    public void testIDs() {
        assertTrue(user.getID() == 1);

        user.setID(3);
        assertTrue(user.getID() == 3);
    }

    @Test
    /**
     * Test the overridden toString method
     */
    public void testToString() {
        String expected = user.toString();

        assertTrue(expected.equals("Username: Bill\nUser ID: 1\n"));
    }

    @Test
    /**
     * Test the overridden equals method
     */
    public void testEquals() {
        user2 = new UserClass("Bill", 1);

        assertTrue(user.equals(user2));

        user2.setName(name);
        user2.setID(2);

        assertFalse(user.equals(user2));
        assertFalse(user.equals("Bob"));
    }
}
