public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public static String convertToString(int n){
        String res = null;

        String[] units = {"", "one", "two", "thee", "four", "five", "six", "seven", "eight", "nine","ten", "eleven", "twelv", "thirteen", "fourteen", "fiveteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tens = {"", "", "twenty", "thirty", "fourty", "fivety", "sixty", "seventy", "eighty", "ninety"};
        String[] hundreds = {"", "one hundred"};
        String[] thousands = {"", "one thousand"};


        String un = n%100 < 20 ? units[n%100] : tens[n%100/10] + "" + units[n%10];
        String th = n/1000%100 < 20 ? units[n%100] + " thousand(s)" : hundreds[n/1000/100%10] + " " + tens[n%100/10] + "" + units[n%10];
        return thousands[n/1000 % 10] + " " +  hundreds[n/100%10] + " " +un;
    }
}
