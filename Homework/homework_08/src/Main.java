public class Main {

    public static void main(String[] args) {

        int[] mass = {50, 8, 33, 22, 19, 9, 7};
        int[] mass1 = {50, 8, 8, 8, 7, 7, 1, 8, 8, 6, 8, 66, 65, 7, 8, 0, 0};
        float[] mass2 = {-50.76F, -8.7F, -7F, -7.9F, -1F, 1, 8, 6, 8, 66, 65, 7, 8, 0, 0};
        int num = 11;


        averageWhile(mass);
        averageForEach(mass);
        averageLowerWhile(mass, 20);
        averageLowerForEach(mass, 20);
        sequence(mass1);
        maxSpeed(mass1);
        notEmptySequence(mass1);
        sequenceFloat(mass2);
        countMaxNum(num);
        reverseNum(1357);

    }
    /*1) Найти среднее арифметическое элементов массива, больших числа 10.
      * Решить задачу при помощи циклов while и for-each*/

    public static void averageWhile(int[] mass) {
        int i = 0;
        int count = 0;
        float average = 0;
        while (i < mass.length) {
            if (mass[i] > 10) {
                average = average + mass[i];
                count++;
            }
            i++;
        }
        average = average / count;
        System.out.println(average);
    }

    public static void averageForEach(int[] mass) {
        int count = 0;
        float average = 0;
        for (int i : mass) {
            if (i > 10) {
                average = average + i;
                count++;
            }
        }
        average = average / count;
        System.out.println(average);
    }

    /* 2) Найти среднее арифметическое элементов массива, меньших некоторого числа m.
    * Решить задачу при помощи циклов while и for-each*/
    public static void averageLowerWhile(int[] arr, int m) {
        int i = 0;
        int count = 0;
        float average = 0;
        while (i < arr.length) {
            if (arr[i] < m) {
                average = average + arr[i];
                count++;
            }
            i++;
        }
        average = average / count;
        System.out.println(average);
    }

    public static void averageLowerForEach(int[] arr, int m) {
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

    public static void sequence(int[] mass1) {
        int countDifferent = 1;
        int k, i, j, repeat, temp;
        k = i = j = repeat = 0;
        int[] result = new int[mass1.length];

        while (j < mass1.length) {
            if (mass1[i] == mass1[j]) {
                repeat++;
                j++;
            } else {
                result[k] = mass1[i];
                k++;
                countDifferent++;
                System.out.println("Количество " + mass1[i] + " в массиве идущих подряд: " + repeat);
                i = repeat + i;
                repeat = 0;
            }
        }
        result[k] = mass1[i];
        System.out.println("Количество " + mass1[i] + " в массиве идущих подряд: " + repeat);
        //Поиск различных чисел в массиве.
        repeat = k = i = 0;
        while (k < countDifferent) {
            System.out.println(result[k]);
            temp = result[k];
            while (i < countDifferent) {
                if(temp == result[i+1]){
                    repeat++;
                }
                i++;
            }
            k++;
            i = k;
        }
        System.out.println("Кочество элементов массива без повторяющихся:  " + countDifferent);
        System.out.println("Количество разных элементов массива:  " + repeat);

    }
   /* 4) В массиве хранится информация о максимальной скорости каждой из 40 марок легковых автомобилей.
    Определить скорости двух самых быстрых автомобилей. * Задачу решить, не используя два прохода по массиву.*/
    public static void maxSpeed(int [] mass1){
        int i,j;
        i = j = 0;
        int maxSpeed1 = mass1[0];
        int maxSpeed2 = mass1[1];
        while (i < mass1.length){
            if(mass1[i] > maxSpeed1){
                maxSpeed1 = mass1[i];
            }
            else if(mass1[i] > maxSpeed2 && mass1[i] <= maxSpeed1){
                maxSpeed2 = mass1[i];
            }
            i++;
        }
        System.out.println(maxSpeed1 + ", " + maxSpeed2);

    }
    /* 5) Дана непустая последовательность целых чисел, оканчивающаяся нулем. Найти:
    а) сумму всех чисел последовательности;
    б) количество всех чисел последовательности.*/
    public static void notEmptySequence(int [] mass1){
        int sum, count, i;
        sum = i = 0;
        while (i < mass1.length){
            if (mass1[i] == 0){
                i++;
                break;
            }
            else{
                sum = sum + mass1[i];
            }
            i++;
        }
        System.out.println("Количество чисел последовательности включая ноль: " + i);
        System.out.println("Cумма всех чисел последовательнгости: " + sum);
    }
    /* 6) Дана последовательность из n вещественных чисел, начинающаяся с отрицательного числа. Определить,
    какое количество отрицательных чисел записано в начале последовательности. Условный оператор не использовать.*/
    public static void sequenceFloat(float[] mass2){
        int i = 0;
        while (mass2[i] < 0){
            i++;
        }
        System.out.println("Количество отрицательных чисел в начале последовательности: " + i);
    }
    /* 7) Дано натуральное число. Определить, сколько раз в нем встречается максимальная цифра
    (например, для числа 132233 ответ равен 3, для числа 46 336 — 2, для числа 12 345 — 1).
    * Задачу решить, не используя два прохода по массиву.*/
    public static void countMaxNum(int num){
        int tempNum, mod, count, maxNum;
        count = maxNum = 0;
        tempNum = num;
        while((num/10) > 0 || num >= maxNum){
            mod = num%10;
            if(mod > maxNum){
                maxNum = mod;
            }
            if (mod == maxNum && mod != 0){
                count++;
            }
            num = num/10;
        }
        System.out.println("Максимальная цифра числа " + tempNum + ": " + maxNum + " - встречается " + count + " раз");

    }
    /* 8) Дано число. Написать программу, которая возвращает его зеркальное отражение в виде числа.*/
    public static int reverseNum(int num){
        int  reverse, tempNum, mod, count;
        reverse = count = 0;
        tempNum = num;
        while ((tempNum/10) > 0 || tempNum >=1){
            tempNum = tempNum/10;
            count++;
        }
        while (count >= 0){
           mod = num%10;
           reverse = reverse + (int)Math.pow(10, (count-1)) * mod;
           num = num/10;
           count--;
        }
        System.out.println(reverse);
        return reverse;
    }
    /* 9) Дано двузначное число. Необходимо написать программу, которая вернет строковое представление данного числа.
    Например, дано число 34, его строковое представление - thirty four.*/





}



