package converter.tests;

import converter.ElbonianArabicConverter;
import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for the ElbonianArabicConverter class.
 */
public class ConverterTests {

    @Test
    public void ElbonianToArabicTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("I");
        assertEquals(1, converter.toArabic());

        ElbonianArabicConverter conv2 = new ElbonianArabicConverter("MMMXX");
        assertEquals(3020, conv2.toArabic());

        ElbonianArabicConverter conv3 = new ElbonianArabicConverter("MDCLXVI");
        assertEquals(1666, conv3.toArabic());

        ElbonianArabicConverter conv4 = new ElbonianArabicConverter("mMlLxX");
        assertEquals(949, conv4.toArabic());

        ElbonianArabicConverter conv5 = new ElbonianArabicConverter("MMdDLXXvV");
        assertEquals(2474, conv5.toArabic());
    }

    @Test
    public void ArabicToElbonianTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1");
        assertEquals("I", converter.toElbonian());

        ElbonianArabicConverter conv2 = new ElbonianArabicConverter("3020");
        assertEquals("MMMXX", converter.toElbonian());

        ElbonianArabicConverter conv3 = new ElbonianArabicConverter("1666");
        assertEquals("MDCLXVI", converter.toElbonian());

        ElbonianArabicConverter conv4 = new ElbonianArabicConverter("949");
        assertEquals("mMlLxX", converter.toElbonian());

        ElbonianArabicConverter conv5 = new ElbonianArabicConverter("2474");
        assertEquals("MMdDLXXvV", converter.toElbonian());
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter conv = new ElbonianArabicConverter("mMMM");
        //throw new MalformedNumberException("TEST");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter conv = new ElbonianArabicConverter("7000");
        //throw new ValueOutOfBoundsException("0");
    }

    // TODO Add more test cases
}
