package converter.numberconversion;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;


public class NumberConversion {

    List<String> hexChars = new ArrayList<>(List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"));

    public NumberConversion() {

    }

    public String convertFractionalNumber(String number, int targetBase, int sourceBase) {
        String[] splitNumber = number.split("\\.");
        String integerPart = splitNumber[0];
        String fractionsPart = splitNumber[1];
        String result = convertNumber(targetBase, sourceBase, integerPart);
        result = result.concat(".").concat(convertFraction(sourceBase, targetBase, fractionsPart));
        return result;
    }

    public String convertFraction(int sBase, int tBase, String fraction) {

        String[] fractionArr = new String[fraction.length()];
        for (int i = 0; i < fraction.length(); i++) {
            fractionArr[i] = String.valueOf(fraction.charAt(i));
        }

        BigDecimal decimal = BigDecimal.ZERO;

        int pow = -1;
        for (String str : fractionArr) {
            int n = hexChars.indexOf(str.toUpperCase());
            decimal = decimal.add(BigDecimal.valueOf(n * Math.pow(sBase, pow--)));
        }

        BigDecimal radix = BigDecimal.valueOf(tBase);
        BigDecimal integral;

        String output = "";
        for (int i = 0; i < 5; i++) {
            decimal = decimal.multiply(radix);
            integral = decimal.setScale(0, RoundingMode.DOWN);
            output = output.concat(hexChars.get(Integer.parseInt(integral.toString())));
            decimal = decimal.subtract(integral);
        }
        return output;
    }


    public String convertNumber(int targetBase, int sourceBase, String numberToConvert) {
        String n = new BigInteger(numberToConvert, sourceBase).toString();
        return new BigInteger(n).toString(targetBase);
    }

}


