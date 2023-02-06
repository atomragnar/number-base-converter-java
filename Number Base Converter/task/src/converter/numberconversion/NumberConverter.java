package converter.numberconversion;

import converter.numberconversion.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Scanner;

public class NumberConverter {

    static Scanner scanner = new Scanner(System.in);
    private int sourceBase;
    private int targetBase;
    NumberConversion numberConversion;
    private String result;

    public NumberConverter() {
        this.numberConversion = new NumberConversion();
    }

    private void setNumberConversion(NumberConversion numberConversion) {
        this.numberConversion = numberConversion;
    }

    public boolean readInitialInput() {
        String input;
        System.out.println("Enter two numbers in format: {source base} {target base} (To quit type /exit)");
        input = scanner.nextLine();
        if (input.equals("/exit")) {
            return false;
        } else {
            String[] numbers = input.split(" ");
            this.sourceBase = Integer.parseInt(numbers[0]);
            this.targetBase = Integer.parseInt(numbers[1]);
            return true;
        }
    }

    public boolean readNumberToConvert() {
        String input;
        System.out.println("Enter a number in base " + this.sourceBase + " to convert to base " + this.targetBase
                + " (To go back type /back)");
        input = scanner.nextLine();
        if (input.equals("/back")) {
            return false;
        } else {
            if (this.sourceBase == this.targetBase) {
                result = input;
                return true;
            }
            if (input.contains(".")) {
                result = numberConversion.convertFractionalNumber(input, this.targetBase, this.sourceBase);
                return true;
            } else {
                result = numberConversion.convertNumber(this.targetBase, this.sourceBase, input);
                return true;
            }
        }
    }

    public void printConvertedNumber() {
        System.out.println("Conversion result: " + this.result);
    }

}




