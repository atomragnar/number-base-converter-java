package converter;

import converter.numberconversion.NumberConverter;

public class Main {

    public static void main(String[] args) {
        // write your code here
        boolean firstLoop = true;
        boolean secondLoop = true;
        NumberConverter numberConverter = new NumberConverter();

        while (firstLoop) {
            if ((firstLoop = numberConverter.readInitialInput())) {
                while ((secondLoop = numberConverter.readNumberToConvert())) {
                    if (secondLoop) {
                        numberConverter.printConvertedNumber();
                    }
                }
            }
        }




    }



}
