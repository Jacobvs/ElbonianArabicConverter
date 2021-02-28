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
    private ElbonianArabicConverter converter;

    @Test
    public void ElbonianToArabicTest1() throws MalformedNumberException, ValueOutOfBoundsException {
        converter = new ElbonianArabicConverter("I");
        assertEquals(1, converter.toArabic());
    }

    @Test
    public void ElbonianToArabicTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        converter = new ElbonianArabicConverter("MDCLXVI");
        assertEquals(1666, converter.toArabic());
    }

    @Test
    public void ElbonianToArabicTest3() throws MalformedNumberException, ValueOutOfBoundsException {
        converter = new ElbonianArabicConverter("MMDCCLXXVII");
        assertEquals(2777, converter.toArabic());
    }

    @Test
    public void ElbonianToArabicTest4() throws MalformedNumberException, ValueOutOfBoundsException {
        converter = new ElbonianArabicConverter("MMmMLXXV");
        assertEquals(2975, converter.toArabic());
    }

    @Test
    public void ElbonianToArabicTest5() throws MalformedNumberException, ValueOutOfBoundsException {
        converter = new ElbonianArabicConverter("MMMdDXXvV");
        assertEquals(3424, converter.toArabic());
    }

    @Test
    public void ElbonianToArabicTest6() throws MalformedNumberException, ValueOutOfBoundsException {
        converter = new ElbonianArabicConverter("dDlLvV");
        assertEquals(444, converter.toArabic());
    }

    @Test
    public void ElbonianToArabicTest7() throws MalformedNumberException, ValueOutOfBoundsException {
        converter = new ElbonianArabicConverter("DCCCLXXXVIII");
        assertEquals(888, converter.toArabic());
    }

    @Test
    public void ElbonianToArabicTest8() throws MalformedNumberException, ValueOutOfBoundsException {
        converter = new ElbonianArabicConverter("MMMmMcCxX");
        assertEquals(3999, converter.toArabic());
    }

    @Test
    public void ArabicToElbonianTest1() throws MalformedNumberException, ValueOutOfBoundsException {
        converter = new ElbonianArabicConverter("1");
        assertEquals("I", converter.toElbonian());
    }

    @Test
    public void ArabicToElbonianTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        converter = new ElbonianArabicConverter("1666");
        assertEquals("MDCLXVI", converter.toElbonian());
    }

    @Test
    public void ArabicToElbonianTest3() throws MalformedNumberException, ValueOutOfBoundsException {
        converter = new ElbonianArabicConverter("2777");
        assertEquals("MMDCCLXXVII", converter.toElbonian());
    }

    @Test
    public void ArabicToElbonianTest4() throws MalformedNumberException, ValueOutOfBoundsException {
        converter = new ElbonianArabicConverter("2975");
        assertEquals("MMmMLXXV", converter.toElbonian());
    }

    @Test
    public void ArabicToElbonianTest5() throws MalformedNumberException, ValueOutOfBoundsException {
        converter = new ElbonianArabicConverter("3424");
        assertEquals("MMMdDXXvV", converter.toElbonian());
    }

    @Test
    public void ArabicToElbonianTest6() throws MalformedNumberException, ValueOutOfBoundsException {
        converter = new ElbonianArabicConverter("444");
        assertEquals("dDlLvV", converter.toElbonian());
    }

    @Test
    public void ArabicToElbonianTest7() throws MalformedNumberException, ValueOutOfBoundsException {
        converter = new ElbonianArabicConverter("888");
        assertEquals("DCCCLXXXVIII", converter.toElbonian());
    }

    @Test
    public void ArabicToElbonianTest8() throws MalformedNumberException, ValueOutOfBoundsException {
        converter = new ElbonianArabicConverter("3999");
        assertEquals("MMMmMcCxX", converter.toElbonian());
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest1() throws MalformedNumberException, ValueOutOfBoundsException {
        converter = new ElbonianArabicConverter("AMM");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        converter = new ElbonianArabicConverter("MMMLXiI");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest3() throws MalformedNumberException, ValueOutOfBoundsException {
        converter = new ElbonianArabicConverter("XXXX");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest4() throws MalformedNumberException, ValueOutOfBoundsException {
        converter = new ElbonianArabicConverter("MMDIV");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest5() throws MalformedNumberException, ValueOutOfBoundsException {
        converter = new ElbonianArabicConverter("MMmC");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest6() throws MalformedNumberException, ValueOutOfBoundsException {
        converter = new ElbonianArabicConverter("DDLXXV");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest7() throws MalformedNumberException, ValueOutOfBoundsException {
        converter = new ElbonianArabicConverter("CCcCLXVI");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest8() throws MalformedNumberException, ValueOutOfBoundsException {
        converter = new ElbonianArabicConverter("MDCcCCVI");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest1() throws MalformedNumberException, ValueOutOfBoundsException {
        converter = new ElbonianArabicConverter("46.97");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        converter = new ElbonianArabicConverter("7000");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest3() throws MalformedNumberException, ValueOutOfBoundsException {
        converter = new ElbonianArabicConverter("0");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest4() throws MalformedNumberException, ValueOutOfBoundsException {
        converter = new ElbonianArabicConverter("-46");
    }
}
