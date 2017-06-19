public class Main {

    public static void main(String[] args) {

     /*   for (int i = 10; i > 0; i--) {

            int sqrt = i * i;
            int cqrt = sqrt * i;

            System.out.println("sqrt" + i + "=" + sqrt);
            System.out.println("cqrt" + i + "=" + +cqrt);
        }*/
          /*  int [] arr = new int [8];

            for (int j = 0; j < arr.length; j++){
                arr[j] = 15 + j;
            }*/
        int[] massiv = {2, 3, 5, 7, 9};
        massiv = getIncrease(massiv);
        for (int j = 0; j < massiv.length; j++) {

            System.out.println(massiv[j]);
        }

    }

     static int[] getIncrease(int[] arr) {

        for (int k = 0; k < arr.length; k++) {
            arr[k] *= 2;
        }
        return arr;
    }
}