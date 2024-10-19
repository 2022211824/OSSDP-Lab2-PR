import Lab2.Solution1;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for Solution1.
 *
 * Test case design:
 * - We use equivalence partitioning to handle different cases:
 *   1. Simple fraction without repeating decimal (e.g., 1/2 = "0.5")
 *   2. Whole number (e.g., 2/1 = "2")
 *   3. Fraction with repeating decimal (e.g., 1/3 = "0.(3)", 4/333 = "0.(012)")
 *   4. Negative result case (e.g., -1/2 = "-0.5")
 *   5. Large numbers case (for performance testing)
 */
public class L2022211824_1_Test {

    // Test simple fraction without repeating decimal
    @Test
    public void testSimpleFraction() {
        Solution1 solution = new Solution1();
        assertEquals("0.5", solution.fractionToDecimal(1, 2));
    }

    // Test whole number
    @Test
    public void testWholeNumber() {
        Solution1 solution = new Solution1();
        assertEquals("2", solution.fractionToDecimal(2, 1));
    }

    // Test fraction with repeating decimal
    @Test
    public void testRepeatingDecimal() {
        Solution1 solution = new Solution1();
        assertEquals("0.(3)", solution.fractionToDecimal(1, 3));
        assertEquals("0.(012)", solution.fractionToDecimal(4, 333));
    }

    // Test negative result
    @Test
    public void testNegativeResult() {
        Solution1 solution = new Solution1();
        assertEquals("-0.5", solution.fractionToDecimal(-1, 2));
        assertEquals("-0.(3)", solution.fractionToDecimal(-1, 3));
    }

    // Test large numbers for performance
    @Test
    public void testLargeNumbers() {
        Solution1 solution = new Solution1();
        assertEquals("0.(142857)", solution.fractionToDecimal(1, 7));
        assertEquals("30.(769230)", solution.fractionToDecimal(400, 13));
    }
}
