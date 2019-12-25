package mobileConnection;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void regExpTest() {
        String testCase = "asdfasdfasdf/5.2/3,7/0/600";
        Pattern pattern = Pattern.compile("(?<name>[^\\/]+)\\/(?<sms>\\d+[.,]?\\d*)\\/(?<minute>\\d+[.,]?\\d*)\\/(?<mb>\\d+[.,]?\\d*)\\/(?<fee>\\d*)");

        String testCase2 = "asdfasdfasdf";
        Matcher matcher = pattern.matcher(testCase);
        Matcher matcher2 = pattern.matcher(testCase2);
        assertTrue(matcher.matches());
        assertFalse(matcher2.matches());

    }

    @Test
    public void regExpTest2() {
        String testCase = "sms 10 50";
        String testCase2 = "sms 10";

        Pattern pattern = Pattern.compile("(?<param>(sms|mb|fee))\\s(?<left>\\d+)\\s(?<right>\\d+)");

        Matcher matcher = pattern.matcher(testCase);
        Matcher matcher2 = pattern.matcher(testCase2);

        assertTrue(matcher.matches());
        assertFalse(matcher2.matches());

        assertEquals("sms", matcher.group("param"));
        assertEquals("10", matcher.group("left"));
        assertEquals("50", matcher.group("right"));

    }
}
