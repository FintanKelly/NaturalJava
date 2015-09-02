package language;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * This will act as the test case for the BooleanL class.
 *
 * @author Harmtouch
 */
public class BooleanLTest {

    /**
     * The variables that will be used in every test case.
     */
    BooleanL language;

    /**
     * Default constructor, nothing is needed in here for setup at the moment.
     */
    public BooleanLTest() {
        language = new BooleanL();
    }

    @Test
    /**
     * Test the checkForTrue method for code accuracy
     */
    public void testCheckForTrue() {
        boolean statementOne = 1 == 1;
        boolean statementTwo = 2 == 1;

        assertTrue(language.checkForTrue(statementOne));

        assertFalse(language.checkForTrue(statementTwo));
        assertFalse(language.checkForTrue(statementOne, statementTwo));
    }

    @Test
    /**
     * Test the checkForFalse method for code accuracy
     */
    public void testCheckForFalse() {
        boolean statementOne = 1 == 1;
        boolean statementTwo = 2 == 1;

        assertFalse(language.checkForFalse(statementOne));

        assertTrue(language.checkForFalse(statementTwo));
        assertTrue(language.checkForFalse(statementOne, statementTwo));
    }
}
