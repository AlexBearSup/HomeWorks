package homeworks.homework9;

import homeworks.homework9.exceptions.ArrayDataException;
import homeworks.homework9.exceptions.ArraySizeException;

import java.util.Arrays;

public class ArrayValueCalculator {
    public ArrayValueCalculator(String[][] incoming) {
    }

    public void doCalc (String[][] incoming) throws ArraySizeException,ArrayDataException {

        if (incoming.length != 4 || incoming[0].length != 4 || incoming[1].length != 4 ||
                incoming[2].length != 4 || incoming[3].length != 4){
            throw new ArraySizeException("Wrong size of array !");
        }

        int totalAmount = 0;
        for (int i = 0; i < incoming.length; i++) {
            for (int j = 0; j < incoming[i].length; j++) {
                try {
                    totalAmount += Integer.parseInt(incoming[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("Wrong data in element (" + i + ", " + j + ")");
                }
            }
        }
        System.out.println("Final result is - " + totalAmount);


    }

}
