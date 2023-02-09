package converter;

import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;

import java.util.HashMap;
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

    /**
     * Constructor for the ElbonianArabic class that takes a string. The string should contain a valid
     * Elbonian or Arabic numeral. The String can have leading or trailing spaces. But there should be no
     * spaces within the actual number (ie. "9 9" is not ok, but " 99 " is ok). If the String is an Arabic
     * number it should be checked to make sure it is within the Elbonian number systems bounds. If the
     * number is Elbonian, it must be a valid Elbonian representation of a number.
     *
     * @param number A string that represents either a Elbonian or Arabic number.
     * @throws ValueOutOfBoundsException Thrown if the value is an Arabic integer that cannot be represented
     * in the Elbonian number system.
     * @throws MalformedNumberException Thrown if the value is an Elbonian number that does not conform
     * to the rules of the Elbonian number system or any other error in Arabic number input.
	 * Leading and trailing spaces should not throw an error.
     */
    public ElbonianArabicConverter(String number) throws MalformedNumberException, ValueOutOfBoundsException {
        String number1;

        // Removes leading and trailing spaces.
        number = number.trim();

        // Accounts for empty String.
        if(number.length() == 0) {
            throw new MalformedNumberException("number is an empty string");
        }

        if(number.equals("0")) {
            throw new ValueOutOfBoundsException(("its 0"));
        }

        // Removes any 0s at the beginning of the number.
//        while((int)number.charAt(0) == 48) {
//            number = number.substring(1);
//        }

        // Checks for any spaces in the middle of number.
        for(int i = 0; i < number.length(); i++) {
            if(number.charAt(i) == ' ') {
                throw new MalformedNumberException("number has spaces in between");
            }
        }

        boolean arabic = false;


        // First checks if number is a sequence of letters. If it is not, the parseDouble will through a NumberFormatException.
        // The Catch statement will then check if number is an alphanumeric. If it is, it will throw an exception.
        // If it is not an alphanumeric, then it will check if number is within the bounds. If not, it will throw an exception.
        // If it is within the bounds, it will check if the number is a decimal. If it is, it will throw an exception.
        // If the number passes all these tests in the catch statement, then it is deemed an arabic number.
        // If the try statement works, then the number is deemed as a elbonian number.
        try {
            Double.parseDouble(number);
            if(Double.parseDouble(number) < 1 || Double.parseDouble(number) > 9999) {
                throw new ValueOutOfBoundsException("number is out of bounds");
            } else if(number.contains(".")) {
                throw new MalformedNumberException("number is a decimal");
            } else {
                arabic = true;
            }
        } catch (NumberFormatException ne) {

            String numRegex   = ".*[0-9].*";
            String alphaRegex = ".*[A-Z].*";
            String lowerAlphaRegex = ".*[a-z].*";
            Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(number);
            boolean b = m.find();
            if(b) {
                throw new MalformedNumberException("number has a special character");
            }
            if(number.matches(numRegex) && (number.matches(alphaRegex) || number.matches(lowerAlphaRegex))) {
                throw new MalformedNumberException("number is an alphanumeric");
            } else if (number.matches(alphaRegex) || number.matches(lowerAlphaRegex) || !number.matches(numRegex)) {
                p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
                m = p.matcher(number);
                b = m.find();
                if(b) {
                    throw new MalformedNumberException("number has a special character");
                }
            } else {
                if(Double.parseDouble(number) < 1 || Double.parseDouble(number) > 9999) {
                    throw new ValueOutOfBoundsException("number is out of bounds");
                }
                if(Double.parseDouble(number) != Integer.parseInt(number)) {
                    throw new MalformedNumberException("number is a decimal");
                }
                arabic = true;
            }
        }

        // Runs if the number is determined to be non-arabic
        if(!arabic) {

            // Checks if number violates the rule that if ____ letter exists, ____ cannot exist
            if((number.contains("n") && number.contains("M"))
                    || (number.contains("d") && number.contains("C"))
                    || (number.contains("l") && number.contains("X"))
                    || (number.contains("v") && number.contains("I")))
            {
                throw new MalformedNumberException("number fails the if ___ letter exists, ___ cannot exist rule");
            }

            //Checks if letters are in order of greatest magnitude and have the correct quantity.
            String[] s = new String[] {"N", "n", "M", "D", "d", "C", "L", "l", "X", "V", "v", "I"};
            Pattern regex = Pattern.compile(s[0]+ "??" + s[1] + "??" + s[2]
                    + "{0,3}?" + s[3] + "??" + s[4] + "??" + s[5] + "{0,3}?"
                    + s[6] + "??" + s[7] + "??" + s[8] + "{0,3}?" + s[9] + "??"
                    + s[10] + "??" + s[11] + "{0,3}?");
            if(!regex.matcher(number).matches()) {
                throw new MalformedNumberException("Skill issue lol");
            }
        }

        this.number = number;
    }

    /**
     * Converts the number to an Arabic numeral or returns the current value as an int if it is already
     * in the Arabic form.
     *
     * @return An arabic value
     */
    public int toArabic() {
        int total = 0;
        HashMap<Character, Integer> data = new HashMap<Character, Integer>();
        data.put('N', 5000);
        data.put('n', 4000);
        data.put('M', 1000);
        data.put('D', 500);
        data.put('d', 400);
        data.put('C', 100);
        data.put('L', 50);
        data.put('l', 40);
        data.put('X', 10);
        data.put('V', 5);
        data.put('v', 4);
        data.put('I', 1);

        try {
            Integer.parseInt(this.number);
        } catch (NumberFormatException ne) {
            for(int i = 0; i < this.number.length(); i++) {
                total += data.get(this.number.charAt(i));
            }
            return total;
        }

        return Integer.parseInt(this.number);
    }

    /**
     * Converts the number to an Elbonian numeral or returns the current value if it is already in the Elbonian form.
     *
     * @return An Elbonian value
     */
    public String toElbonian() {
        String total = "";

        try {
            Integer.parseInt(this.number);
        } catch (NumberFormatException ne) {
            return this.number;
        }
        int temp = Integer.parseInt(this.number);
        while(temp != 0) {
            if(temp - 5000 >= 0) {
                total = total + "N";
                temp -= 5000;
            } else if (temp - 4000 >= 0) {
                total = total + "n";
                temp -= 4000;
            } else if (temp - 1000 >= 0) {
                total = total + "M";
                temp -= 1000;
            } else if (temp - 500 >= 0) {
                total = total + "D";
                temp -= 500;
            } else if (temp - 400 >= 0) {
                total = total + "d";
                temp -= 400;
            } else if (temp - 100 >= 0) {
                total = total + "C";
                temp -= 100;
            } else if (temp - 50 >= 0) {
                total = total + "L";
                temp -= 50;
            } else if (temp - 40 >= 0) {
                total = total + "l";
                temp -= 40;
            } else if (temp - 10 >= 0) {
                total = total + "X";
                temp -= 10;
            } else if (temp - 5 >= 0) {
                total = total + "V";
                temp -= 5;
            } else if (temp - 4 >= 0) {
                total = total + "v";
                temp -= 4;
            } else if (temp - 1 >= 0) {
                total = total + "I";
                temp -= 1;
            }
        }
        return total;
    }

}