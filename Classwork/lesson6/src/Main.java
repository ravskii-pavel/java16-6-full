public class Main {

    public static void main(String[] args) {

        int i = 11;
        int j = 9;
        isEven(i);
        isWin(i, j);
        int num = 74;
        float num1 = 34.87F;
        float num2 = 32.43F;
        System.out.println(whichBiggest(num));
        System.out.println(whichBiggest1(num1, num2));
    }

    public static void isEven(int a) {
        if (a == 9) {
            System.out.println("День программиста");
        } else {
            System.out.println("Работает");
        }
    }

    public static String isWin(int team1, int team2) {
        String result = null;
        if (team1 > team2) {
            result = "выиграш team1";
            System.out.println(result);
        } else if (team1 < team2) {
            System.out.println("выиграла team2");
        } else {
            System.out.println("ничья");
        }
        return result;
    }

    public static String whichBiggest(int num) {

        String result = null;

        if (num % 10 > num / 10) {
            result = "second biggesst";
            return result;
        }
        if (num % 10 < num / 10) {
            result = "first biggesst";
            return result;
        }
        //if (num % 10 == num / 10) {
        else{
            result = "одинаковые";
            return result;
        }
        //return result;
    }
    public static String whichBiggest1(float num1, float num2) {

        String result = "одинаковые";
        if (num1 > num2) {
            result = "first biggesst";
            return result;
        }
        if (num1 < num2) {
            result = "second biggesst";
            return result;
        }
        return result;
    }

    /*public static boolean isLuckky(int num){
        int first = num%1000;
        int second = num/1000;
        if ((second%10)+(second/10)%10)+){

        }*/

    }
}
