package ua.com.formula;
import java.io.*;

/**
 * Created by ravskiy on 27.02.2017.
 */
public class ChangeFormula {
    public static void main(String[] args) throws IOException {
        ioFormula(args[0], args[1]);
    }

    public static void ioFormula(String inputFilename, String outputFilename) throws IOException {

        InputStream input = new FileInputStream(inputFilename);
        OutputStream out = new FileOutputStream(outputFilename);
        String formula = "";
        int data;
        while ((data = input.read()) >= 0) {
            formula = formula + String.valueOf((char) data);
        }
        out.write((formula + "\r\n").getBytes());
        out.write(checkFormula(formula).getBytes());
        input.close();
        out.close();
    }
    public static String checkFormula(String formula) {
        char[] sourceFormula = formula.toCharArray();
        char[] resultFormula = (fillSpaces(sourceFormula.length));
        for (int i = 0; i < sourceFormula.length; i++) {
            if (sourceFormula[i] == '(') {
                resultFormula[i] = '(';
            }
            else if (sourceFormula[i] == ')') {
                if(!new String(resultFormula).contains("(")){
                    resultFormula[i] = ')';
                }
                else {
                    for (int k = i; k >=0; k--) {
                        if (resultFormula[k] == '(') {
                            resultFormula[k] = ' ';
                            break;
                        }
                    }
                }
            }
        }
        return String.valueOf(fillHead(resultFormula));
    }
    public static char[] fillSpaces(int length){
        char arr[] = new char [length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ' ';
        }
        return arr;
    }
    public static char[] fillHead(char arr[]){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(' || arr[i] == ')') arr[i] = '^';
        }
        return arr;
    }
}
