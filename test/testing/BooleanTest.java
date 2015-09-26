package testing;

import language.BooleanLanguage;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * This will act as the test case for the BooleanLanguage class. Note: This
 * class will not explain the reasoning or logic behind functionality, all of
 * that can be found in the BooleanLanguage class itself.
 *
 * @author Harmtouch
 */
public class BooleanTest {

    /**
     * The variables that will be used in every test case.
     */
    BooleanLanguage language;
    boolean statementOne, statementTwo, statementThree, statementFour;

    /**
     * Default constructor, nothing is needed in here for setup at the moment.
     */
    public BooleanTest() {
    }

    @Before
    /**
     * Set up all the necessary material for testing the BooleanLanguage class
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
        assertTrue(BooleanLanguage.and(statementOne));
        assertTrue(BooleanLanguage.and(statementOne, statementThree));

        assertFalse(BooleanLanguage.and(statementTwo));
        assertFalse(BooleanLanguage.and(statementOne, statementTwo));
    }

    @Test
    /**
     * Test the 'or' method for code accuracy
     */
    public void testOr() {
        assertTrue(BooleanLanguage.or(statementOne));
        assertTrue(BooleanLanguage.or(statementOne, statementTwo));

        assertFalse(BooleanLanguage.or(statementTwo));
        assertFalse(BooleanLanguage.or(statementTwo, statementFour));
    }

    @Test
    /**
     * Test the 'and' method for code accuracy
     */
    public void testNot() {
        assertTrue(BooleanLanguage.checkForFalse(statementTwo));
        assertTrue(BooleanLanguage.checkForFalse(statementTwo, statementFour));

        assertFalse(BooleanLanguage.checkForFalse(statementOne));
        assertFalse(BooleanLanguage.checkForFalse(statementOne, statementTwo));
    }

    @Test
    /**
     * Test the 'compareIdentity' method for code accuracy
     */
    public void testCompareIdentity() {
        Integer a = new Integer(1);
        Integer b = a;
        Integer c = new Integer(1);

        assertTrue(BooleanLanguage.compareIdentity(a, b));
        assertFalse(BooleanLanguage.compareIdentity(a, c));
        assertFalse(BooleanLanguage.compareIdentity(a, c, b));
        assertTrue(BooleanLanguage.compareIdentity());
    }

    @Test
    /**
     * Test the 'compareEquality' method for code accuracy
     */
    public void testCompareEquality() throws Exception {
        Integer a = new Integer(1);
        Integer b = a;
        Integer c = new Integer(2);

        assertTrue(BooleanLanguage.compareEquality(false, a, b));
        assertFalse(BooleanLanguage.compareEquality(false, a, c));
    }
}
