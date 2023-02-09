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

    // SAMPLE TESTS
    @Test
    public void ElbonianToArabicSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1");
        assertEquals(converter.toElbonian(), "I");
    }

    @Test
    public void ArabicToElbonianSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("I");
        assertEquals(converter.toArabic(), 1);
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("TEST");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new ValueOutOfBoundsException("0");
    }

    //ELBONIAN TO ARABIC

    //Successful conversions
    @Test
    public void ValidConversionElbonianToArabic1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMCXX");
        assertEquals(converter.toArabic(), 2120);
    }

    @Test
    public void ValidConversionElbonianToArabic2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("CCXII");
        assertEquals(converter.toArabic(), 212);
    }

    @Test
    public void ValidConversionElbonianToArabic3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMMCCv");
        assertEquals(converter.toArabic(), 3204);
    }

    @Test
    public void ValidConversionElbonianToArabic4() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("NnDdLlVv");
        assertEquals(converter.toArabic(), 9999);
    }

    @Test
    public void ValidConversionElbonianToArabic5() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("NMMCCCI");
        assertEquals(converter.toArabic(), 7301);
    }

    @Test
    public void ValidConversionElbonianToArabic6() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("DLI");
        assertEquals(converter.toArabic(), 551);
    }

    @Test
    public void ValidConversionElbonianToArabic9() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("CLXXVIII");
        assertEquals(converter.toArabic(), 178);
    }


    //Too many M, C, X, I
    @Test (expected = MalformedNumberException.class)
    public void InvalidConversionElbonianToArabic1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMMM");
        converter.toArabic();
    }

    @Test (expected = MalformedNumberException.class)
    public void InvalidConversionElbonianToArabic2() throws ValueOutOfBoundsException, MalformedNumberException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMCCCC");
        converter.toArabic();
    }

    //If one appears, the other can't appear
    @Test (expected = MalformedNumberException.class)
    public void InvalidConversionElbonianToArabic3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMn");
        converter.toArabic();
    }

    @Test (expected = MalformedNumberException.class)
    public void InvalidConversionElbonianToArabic4() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MCd");
        converter.toArabic();
    }

    @Test (expected = MalformedNumberException.class)
    public void InvalidConversionElbonianToArabic4Duplicate() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MdC");
        converter.toArabic();
    }

    @Test (expected = MalformedNumberException.class)
    public void InvalidConversionElbonianToArabic5() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMCXXl");
        converter.toArabic();
    }

    @Test (expected = MalformedNumberException.class)
    public void InvalidConversionElbonianToArabic6() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("nIv");
        converter.toArabic();
    }

    //Duplicates of N, n, D, d, L, l, V, v
    @Test (expected = MalformedNumberException.class)
    public void InvalidConversionElbonianToArabic7() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("vv");
        converter.toArabic();
    }

    @Test (expected = MalformedNumberException.class)
    public void InvalidConversionElbonianToArabic8() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("LVVVV");
        converter.toArabic();
    }

    @Test (expected = MalformedNumberException.class)
    public void InvalidConversionElbonianToArabic9() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("NCllI");
        converter.toArabic();
    }

    @Test (expected = MalformedNumberException.class)
    public void InvalidConversionElbonianToArabic10() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MCLLLLLV");
        converter.toArabic();
    }

    @Test (expected = MalformedNumberException.class)
    public void InvalidConversionElbonianToArabic11() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("NNd");
        converter.toArabic();
    }

    @Test (expected = MalformedNumberException.class)
    public void InvalidConversionElbonianToArabic12() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MDDX");
        converter.toArabic();
    }

    @Test (expected = MalformedNumberException.class)
    public void InvalidConversionElbonianToArabic13() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("nnnnnnn");
        converter.toArabic();
    }

    @Test (expected = MalformedNumberException.class)
    public void InvalidConversionElbonianToArabic14() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("NN");
        converter.toArabic();
    }

    //Numbers in wrong order of magnitude
    @Test (expected = MalformedNumberException.class)
    public void InvalidConversionElbonianToArabic15() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("vLCM");
        //converter.toArabic();
    }

    @Test (expected = MalformedNumberException.class)
    public void InvalidConversionElbonianToArabic16() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMXCX");
        //converter.toArabic();
    }

    //Spaces in between
    @Test (expected = MalformedNumberException.class)
    public void ElbonianToArabicSpaces1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMC XX");
        converter.toArabic();
    }

    @Test (expected = MalformedNumberException.class)
    public void ElbonianToArabicSpaces2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("M MC XX");
        converter.toArabic();
    }

    @Test (expected = MalformedNumberException.class)
    public void ElbonianToArabicSpaces3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("M M C X X");
        converter.toArabic();
    }

    @Test (expected = MalformedNumberException.class)
    public void ElbonianToArabicSpaces4() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("DdL v");
        converter.toArabic();
    }

    //Leading or trailing spaces
    @Test
    public void ValidConversionElbonianToArabic7() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("   MMCXX");
        assertEquals(converter.toArabic(), 2120);
    }

    @Test
    public void ValidConversionElbonianToArabic8() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMCXX ");
        assertEquals(converter.toArabic(), 2120);
    }

    // Invalid letters
    @Test (expected = MalformedNumberException.class)
    public void ElbonianToArabicNotLetters() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMDx");
        assertEquals(converter.toArabic(), 2120);
    }

    // Simple
    @Test
    public void ElbonianToArabicEasy1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("M");
        assertEquals(converter.toArabic(), 1000);
    }

    @Test
    public void ElbonianToArabicEasy2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("n");
        assertEquals(converter.toArabic(), 4000);
    }

    @Test
    public void ElbonianToArabicEasy3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("d");
        assertEquals(converter.toArabic(), 400);
    }

    @Test
    public void ElbonianToArabicEasy4() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("L");
        assertEquals(converter.toArabic(), 50);
    }

    @Test
    public void ElbonianToArabicEasy5() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("X");
        assertEquals(converter.toArabic(), 10);
    }

    // Out of bounds
    @Test (expected = MalformedNumberException.class)
    public void ElbonianToArabicEmpty() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("");
    }

    //ARABIC TO ELBONIAN -------------------------------------------------------------------
    @Test
    public void ValidConversionArabicToElbonian1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1354");
        assertEquals(converter.toElbonian(), "MCCCLv");
    }

    @Test
    public void ValidConversionArabicToElbonian2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("2120");
        assertEquals(converter.toElbonian(), "MMCXX");
    }

    @Test
    public void ValidConversionArabicToElbonian3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("312");
        assertEquals(converter.toElbonian(), "CCCXII");
    }

    @Test
    public void ValidConversionArabicToElbonian4() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("9999");
        assertEquals(converter.toElbonian(), "NnDdLlVv");
    }

    @Test
    public void ValidConversionArabicToElbonian5() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("2");
        assertEquals(converter.toElbonian(), "II");
    }

    @Test
    public void ValidConversionArabicToElbonian6() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("0000000000000000000000002");
        assertEquals(converter.toElbonian(), "II");
    }

    //Out of bounds inputs
    @Test (expected = ValueOutOfBoundsException.class)
    public void InvalidConversionArabicToElbonian1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1000000");
    }

    @Test (expected = ValueOutOfBoundsException.class)
    public void InvalidConversionArabicToElbonian2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("0");
    }

    @Test (expected = ValueOutOfBoundsException.class)
    public void InvalidConversionArabicToElbonian3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("-1");
    }

    @Test (expected = MalformedNumberException.class)
    public void InvalidConversionArabicToElbonian4() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("2.3");
    }

    @Test (expected = ValueOutOfBoundsException.class)
    public void InvalidConversionArabicToElbonian5() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("2147483649");
    }

    @Test (expected = ValueOutOfBoundsException.class)
    public void InvalidConversionArabicToElbonian6() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("-2.3");
    }

    // TEST to___ methods on itself
    @Test
    public void ElbonianToElbonian1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("X");
        assertEquals(converter.toElbonian(), "X");
    }
    @Test
    public void ElbonianToElbonian2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMCCV");
        assertEquals(converter.toElbonian(), "MMCCV");
    }
    @Test
    public void ElbonianToElbonian3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("dLv");
        assertEquals(converter.toElbonian(), "dLv");
    }

    @Test (expected = MalformedNumberException.class)
    public void InvalidElbonianToElbonian1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("Mll");
    }
    @Test (expected = MalformedNumberException.class)
    public void InvalidElbonianToElbonian2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("vV");
    }
    @Test (expected = MalformedNumberException.class)
    public void InvalidElbonianToElbonian3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("");
    }

    // Test with special characters.
    @Test (expected = MalformedNumberException.class)
    public void SpecialCharacter1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("`");
    }

    @Test (expected = MalformedNumberException.class)
    public void SpecialCharacter2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("6942)(*&^^");
    }

    @Test (expected = MalformedNumberException.class)
    public void SpecialCharacter3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("M & C");
    }

    @Test (expected = MalformedNumberException.class)
    public void SpecialCharacter4() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("F");
    }

    @Test (expected = MalformedNumberException.class)
    public void SpecialCharacter5() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MCF");
    }

    @Test (expected = MalformedNumberException.class)
    public void SpecialCharacter6() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("#(&(&#^(#&(&(_!@(%@(@%(@M");
    }

    @Test (expected = MalformedNumberException.class)
    public void SpecialCharacter7() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("0*");
    }

    @Test (expected = MalformedNumberException.class)
    public void SpecialCharacter8() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("0M");
    }

    @Test (expected = MalformedNumberException.class)
    public void SpecialCharacter9() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("I0");
    }

    @Test (expected = MalformedNumberException.class)
    public void SpecialCharacter10() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("IO");
    }
}