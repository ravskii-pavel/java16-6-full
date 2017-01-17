package calculator;

/**
 * Created by ravskiy on 17.01.2017.
 */
public class Operations{

    public static boolean isOperation(String textFieldLine){
        if (textFieldLine.startsWith("-")){
            textFieldLine = (textFieldLine.substring(1, textFieldLine.length()));
        }
        if (textFieldLine.contains("-") || textFieldLine.contains("+") || textFieldLine.contains("/") || textFieldLine.contains("*")){
            return true;
        }
        else {
            return  false;
        }
    }
    public static String whichIsOperation(String textFieldLine){
        char [] text = textFieldLine.toCharArray();
        if (isOperation(textFieldLine)) {
            for (int i = 0; i < text.length; i++) {
                if ((text[i] == '-' || text[i] == '+' || text[i] == '/' || text[i] == '*') && i!=0) {
                    return String.valueOf(text[i]);
                }
            }
        }
        return "operator is missing";
    }
    public static boolean isDotExist(String textField){
        if(textField.contains(".")){
            return true;
        }
        return  false;
    }
    public static boolean isSecondOperandExist(String txt){
        String secondOperand = txt.substring(txt.lastIndexOf(Operations.whichIsOperation(txt))+1, txt.length());
        if(secondOperand.equals("")){
            return false;
        }
        return true;
    }
    public static String isError(String textField){
        if(textField.equals("Error")){
            return "0";
        }
        return  textField;
    }
    public static boolean isInfinity(String resultText){

        if (resultText.equals("Infinity") || resultText.equals("NaN") || resultText.equals("-Infinity")) {
            return true;
        }
        return false;
    }
    public static void resultAndSecondOperation(String txt, String operation){
        String result;

        if (Operations.isOperation(txt) && Operations.isSecondOperandExist(txt) == true){
            Operations.result(txt);
            result = Calculator.textField.getText();
            //result = isError(result);
            Calculator.textField.setText(result + operation);
        }
        else if (Operations.isOperation(txt)){}

        else {
            if (txt.endsWith(".")){
                txt = txt.substring(0, txt.length()-1);
            }
            Calculator.textField.setText(txt + operation);
        }
    }
    public static void result(String txt){
        //txt = Calculator.textField.getText();
        String result ="";
        String firstOperand = "";
        String secondOperand = "";
        Object firstOp;
        Object secondOp;
        if(Operations.isOperation(txt)){
            firstOperand = txt.substring(0, txt.lastIndexOf(Operations.whichIsOperation(txt)));
            secondOperand = txt.substring(txt.lastIndexOf(Operations.whichIsOperation(txt))+1, txt.length());
        }
        else{
            firstOperand = txt;
        }
        String op = Operations.whichIsOperation(txt);

        if(txt.equals("0")) {
        }
        else if (Operations.isOperation(txt) && secondOperand.equals("") == false){
            if(Operations.isDotExist(firstOperand) || Operations.isDotExist(secondOperand)){
                firstOp = Double.parseDouble(firstOperand);
                secondOp = Double.parseDouble(secondOperand);
            }
            else {
                firstOp = Integer.parseInt(firstOperand);
                secondOp = Integer.parseInt(secondOperand);
            }
            result = ArithmeticalOperations.getResult(op, firstOp, secondOp);
            if (isInfinity(result)) {
                Calculator.textField.setText("Error");
            }
            else {
                Calculator.textField.setText(ArithmeticalOperations.getResult(op, firstOp, secondOp));
            }
        }
    }
}
