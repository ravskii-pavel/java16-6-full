public class Main {

    public static void main(String[] args) {

        int [] mass = {50, 8, 33, 22, 19, 9, 7};
        int [] mass1 = {50, 8, 8, 8, 8, 8, 7, 7, 1, 8, 8, 6, 8, 66, 65, 65, 7, 8, 0, 0};

        averageWhile(mass);
        averageForEach(mass);
        averageLowerWhile(mass, 20);
        averageLowerForEach(mass, 20);
        sequence(mass1);

    }
    /*1) Найти среднее арифметическое элементов массива, больших числа 10.
      * Решить задачу при помощи циклов while и for-each*/

    public static void averageWhile(int [] mass){
        int i = 0;
        int count = 0;
        float average = 0;
        while(i < mass.length){
            if(mass[i] > 10){
                average = average + mass[i];
                count++;
            }
            i++;
        }
        average= average/count;
        System.out.println(average);
    }
    public static void averageForEach(int [] mass){
        int count = 0;
        float average = 0;
        for (int i : mass){
            if(i > 10){
                average = average + i;
                count++;
            }
        }
        average= average/count;
        System.out.println(average);
    }

    /* 2) Найти среднее арифметическое элементов массива, меньших некоторого числа m.
    * Решить задачу при помощи циклов while и for-each*/
    public static void averageLowerWhile(int [] arr, int m){
        int i = 0;
        int count = 0;
        float average = 0;
        while(i < arr.length){
            if(arr[i] < m){
                average = average + arr[i];
                count++;
            }
            i++;
        }
        average= average/count;
        System.out.println(average);
    }

    public static void averageLowerForEach(int [] arr, int m) {
        int count = 0;
        float average = 0;
        for (int i : arr) {
            if (i < m) {
                average = average + i;
                count++;
            }
        }
        average = average / count;
        System.out.println(average);
    }

    /*3) В массиве из 20 элементов числа образуют неубывающую последовательность. Несколько элементов, идущих подряд,
    равны между собой. Найти количество таких элементов. Сколько различных чисел имеется в массиве?*/

    public static void sequence(int [] mass1){
        int countDifferent = 0;
        int repeat = 1;
        int k = 1;
        int i =0;
        int j = 1;
        while (i < mass1.length) {
            while (k < mass1.length) {
                if (mass1[i] == mass1[k]){
                    countDifferent++;
                }
                k++;
                if(k == (mass1.length-1)){
                    break;
                }
            }
            k=1;
            if (mass1[i] == mass1[j]) {
                repeat++;
            } else {
                countDifferent++;
                System.out.println("Количество " + mass1[i] + " в массиве идущих подряд: " + repeat);
                repeat = 1;
            }
            j++;
            i++;
        }
        System.out.println("Количество " + mass1[i] + " в массиве идущих подряд: " + repeat);
        System.out.println("Количество различных чисел в масиве: " + countDifferent);

    }

}


