package testing;

import language.BooleanLanguage;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * This will act as the test case for the BooleanLanguage class.
 *
 * @author Harmtouch
 */
public class BooleanLTest {

    /**
     * The variables that will be used in every test case.
     */
    BooleanLanguage language;
    boolean statementOne, statementTwo, statementThree, statementFour;

    /**
     * Default constructor, nothing is needed in here for setup at the moment.
     */
    public BooleanLTest() {
    }

    @Before
    /**
     * Set up all the necessary material for testing the BooleanL class
     */
    public void setUp() {
        language = new BooleanLanguage();

        statementOne = (1 == 1);
        statementTwo = (2 == 1);
        statementThree = (2 == 2);
        statementFour = (2 == 3);
    }

    @Test
    /**
     * Test the checkForTrue method for code accuracy
     */
    public void testCheckForTrue() {
        assertTrue(BooleanLanguage.checkForTrue(statementOne));
        assertTrue(BooleanLanguage.checkForTrue(statementOne, statementThree));

        assertFalse(BooleanLanguage.checkForTrue(statementTwo));
        assertFalse(BooleanLanguage.checkForTrue(statementOne, statementTwo));
    }

    @Test
    /**
     * Test the checkForFalse method for code accuracy
     */
    public void testCheckForFalse() {
        assertTrue(BooleanLanguage.checkForFalse(statementTwo));
        assertTrue(BooleanLanguage.checkForFalse(statementTwo, statementFour));

        assertFalse(BooleanLanguage.checkForFalse(statementOne));
        assertFalse(BooleanLanguage.checkForFalse(statementOne, statementTwo));
    }

    @Test
    /**
     * Test the 'and' method for code accuracy
     */
    public void testAnd() {
        testCheckForTrue();
    }

    @Test
    /**
     * Test the 'or' method for code accuracy
     */
    public void testOr() {
        assertTrue(BooleanLanguage.or(statementOne));
        assertTrue(BooleanLanguage.or(statementOne, statementTwo));

        assertFalse(language.or(statementTwo));
        assertFalse(language.or(statementTwo, statementFour));
    }
}
