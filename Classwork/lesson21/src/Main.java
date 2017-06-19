public class Main {

    public static void main(String[] args) {

        System.out.println(summ(339));
    }
    public static int summ(int N){

        if (N<10){
            return N;
        }
        else {
            return summ(N/10)+ N%10;
        }
    }
}
