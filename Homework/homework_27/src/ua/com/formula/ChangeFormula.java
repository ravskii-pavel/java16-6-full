package ua.com.formula;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ravskiy on 27.02.2017.
 */
public class ChangeFormula {
    public static void main(String[] args) {
        System.out.println(args);
    }

    public static void takingFormula(String filename) throws IOException {

        InputStream input = new FileInputStream(filename);
        StringBuilder result = new StringBuilder();
        int data;
        while ((data = input.read()) >= 0) {
            result.append((char) data);
        }
        input.close();
        System.out.println(result.toString());
    }
    public static void checkFormula(String formula){

        char[] sourceFormula = formula.toCharArray();
        char[] resultFormula = new char[sourceFormula.length];
        int j = 0;
        for (int i = 0; i < sourceFormula.length; i++ ){
            while(j > 0){

            }
        }

    }


}
