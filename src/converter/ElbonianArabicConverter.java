// Assignment 4: Jacob van Steyn & Daniel Stusalitus
package converter;

import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class implements a converter that takes a string that represents a number in either the
 * Elbonian or Arabic numeral form. This class has methods that will return a value in the chosen form.
 *
 * @version 3/18/17
 */
public class ElbonianArabicConverter {

    // A string that holds the number (Elbonian or Arabic) you would like to convert
    private final String number;
    int[] aParts = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] eParts = {"M", "mM", "D", "dD", "C", "cC", "L", "lL", "X", "xX", "V", "vV", "I"};

    private final Map<String, Integer[]> valueMap = new HashMap<>();

    /**
     * Constructor for the ElbonianArabic class that takes a string. The string should contain a valid
     * Elbonian or Arabic numeral. The String can have leading or trailing spaces. But there should be no
     * spaces within the actual number (ie. "9 9" is not ok, but " 99 " is ok). If the String is an Arabic
     * number it should be checked to make sure it is within the Elbonian number systems bounds. If the
     * number is Elbonian, it must be a valid Elbonian representation of a number.
     *
     * @param number A string that represents either a Elbonian or Arabic number.
     * @throws MalformedNumberException Thrown if the value is an Elbonian number that does not conform
     * to the rules of the Elbonian number system. Leading and trailing spaces should not throw an error.
     * @throws ValueOutOfBoundsException Thrown if the value is an Arabic number that cannot be represented
     * in the Elbonian number system.
     */
    public ElbonianArabicConverter(String number) throws MalformedNumberException, ValueOutOfBoundsException {
        valueMap.put("M", new Integer[]{1000, 100});
        valueMap.put("D", new Integer[]{500, 100});
        valueMap.put("C", new Integer[]{100, 10});
        valueMap.put("L", new Integer[]{50, 10});
        valueMap.put("X", new Integer[]{10, 1});
        valueMap.put("V", new Integer[]{5, 1});
        valueMap.put("I", new Integer[]{1, 0});
        // Elbonian Numerals: M, D, C, L, X, V, I
        // lowercase Numerals: m, d, c, l, x, v
        // M,C,X,I repeated up to 3x (XX=20)(MMM=3k)
        // ORDERED largest to smallest then summed [m, d, c, l, x, v, i]
        // Subtraction rule: lowercase to left = subtraction
            // M,C,X lower = 1/10, D,L,V = 1/5
        // D,L,V can only appear once
        // dD cannot be followed by C
        // lL cannot be followed by X
        // vV cannot be followed by I
        // mM cannot be followed by D,C but cC is ok
        // cC cannot be followed by L,X but xX is ok
        // xX cannot be followed by V,I
        // TODO check to see if the number is valid, then set it equal to the string
        try{
            int i = Integer.parseInt(number);
            if (i > 4000)
                throw new ValueOutOfBoundsException("Provided Arabic Number is too high!(Greater than 4000)");
            if (i < 1)
                throw new ValueOutOfBoundsException("Provided Arabic Number is too low!(Less than 1)");
        } catch (NumberFormatException e){
            try {
                Double.parseDouble(number);
                throw new ValueOutOfBoundsException("Provided Arabic Number needs to be an Integer!(Double was provided)");
            } catch (NumberFormatException ignored){
                if(!number.trim().matches("^M{0,3}(mM|D?(dD|C{0,3}))(cC|L?(lL|X{0,3}))(xX|V?(vV|I{0,3}))$"))
                    throw new MalformedNumberException("Provided Elbonian Numeral is invalid!");
            }
        }

        this.number = number;

//        if(number.chars().filter(c->c=='D').count() > 1 ||
//                number.chars().filter(c->c=='L').count() > 1 ||
//                number.chars().filter(c->c=='V').count() > 1)
//            throw new MalformedNumberException("D, L, & V can only appear once in a string!");
    }

    /**
     * Converts the number to an Arabic numeral or returns the current value as an int if it is already
     * in the Arabic form.
     *
     * @return An arabic value
     */
    public int toArabic() {
        // TODO Fill in the method's body
        int arabicNum = 0;

        Pattern pattern = Pattern.compile("[MDCLXVI]|mM|dD|cC|lL|xX|vV");
        Matcher matcher = pattern.matcher(number);

        ArrayList<String> components = new ArrayList<>();
        while(matcher.find())
            components.add(matcher.group());
        int i = 0;
        for(String s: components){
            if(! (i < 13))
                break;
            while(!s.equals(eParts[i]))
                i++;
            arabicNum += aParts[i];
        }
        return arabicNum;
    }

    /**
     * Converts the number to an Elbonian numeral or returns the current value if it is already in the Elbonian form.
     *
     * @return An Elbonian value
     */
    public String toElbonian() {
        // TODO Fill in the method's body
        int arabic = Integer.parseInt(number.trim());
        String elbonian = "";

        for(int i = 0; i < 13; i++){
            while(arabic >= aParts[i]){
                elbonian += eParts[i];
                arabic -= aParts[i];
            }
        }

        return elbonian;
    }

}
