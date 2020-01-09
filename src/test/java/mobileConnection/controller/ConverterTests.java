package mobileConnection.controller;

import mobileConnection.controller.utilities.Converter;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ConverterTests {

    @Test
    public void testSimpleObjectsWithLastFalse(){
        String [] testArray = {"1", "2", "3"};
        String result = Converter.anyListToString(testArray, "-", false);

        assertEquals("1-2-3", result);
    }

    @Test
    public void testSimpleObjectsWithLastTrue(){
        String [] testArray = {"1", "2", "3"};
        String result = Converter.anyListToString(testArray, "-", true);
        assertEquals("1-2-3-", result);
    }
}
