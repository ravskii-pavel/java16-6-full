package parser;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Ravskiy Pavel on 12.03.2017.
 */
public class GenerateNumbers {

    public int searchNumber(ArrayList<Integer> list) {

        int i =0;
        while (Collections.frequency(list, list.get(i)) >= 2){
            i++;
        }
        return list.get(i);
    }


    public ArrayList<Integer> generateNumbers(int oddNum) {

        ArrayList<Integer> arrNumbers = new ArrayList();
        Random rand = new Random();
        int num = 0;
        int countMatches = 0;
        oddNum = (oddNum % 2 == 0) ? oddNum + 1 : oddNum;
        for (int i = 0; i < oddNum; i++) {
            num = rand.nextInt(1000);
            countMatches = Collections.frequency(arrNumbers, num);
            while (countMatches > 1) {
                num = rand.nextInt(1000);
                countMatches = Collections.frequency(arrNumbers, num);
            }
            if (i == (oddNum - 1)) {
                arrNumbers.add(num);
            } else {
                arrNumbers.add(num);
                arrNumbers.add(num);
            }
        }
        Collections.sort(arrNumbers);
        return arrNumbers;
    }
}