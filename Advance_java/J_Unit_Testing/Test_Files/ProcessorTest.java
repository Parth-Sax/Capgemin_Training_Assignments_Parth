import org.example.StringProcessor;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProcessorTest {
    private final StringProcessor processor = new StringProcessor();

    @Test
    public void testConcatenateSuccess() {
        String result = processor.concatenate("Hello", "World");
        assertEquals("HelloWorld", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConcatenateNullFirst() {
        processor.concatenate(null, "World");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConcatenateNullSecond() {
        processor.concatenate("Hello", null);
    }

    @Test
    public void testIsPalindromeTrue() {
        assertTrue(processor.isPalindrome("madam"));
    }

    @Test
    public void testIsPalindromeFalse() {
        assertFalse(processor.isPalindrome("hello"));
    }

    @Test
    public void testIsPalindromeNull() {
        assertFalse(processor.isPalindrome(null));
    }
}
