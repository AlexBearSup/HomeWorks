package homeworks.homework9;

import homeworks.homework9.exceptions.ArrayDataException;
import homeworks.homework9.exceptions.ArraySizeException;

public class Main {


    public static void main(String[] args) {


        String[][] incoming = {
                { "1","1","1","1"},
                { "1","1","1","1"},
                { "1","1","1","1"},
                { "1","1","1","1"},
        };
        ArrayValueCalculator arrayValueCalculator = new ArrayValueCalculator(incoming);

        try {
            arrayValueCalculator.doCalc(incoming);
        } catch (ArraySizeException | ArrayDataException exc){
            System.out.println(exc.getMessage());
        }
    }
}
