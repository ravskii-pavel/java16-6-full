import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Ravskiy Pavel on 12.03.2017.
 */
public class ParseYAML {

    RandomAccessFile file;

    public int searchNumber(){

        return ;
    }

    public RandomAccessFile generationFile(int oddNum){

        ArrayList<Integer> arrNumbers = new ArrayList();
        Random rand = new Random();
        int num = 0;
        int countMatches = 0;
        oddNum = (oddNum % 2 == 0) ? oddNum : oddNum + 1;
        for (int i = 0; i < oddNum; i++){
            num = rand.nextInt();
            countMatches = Collections.frequency(arrNumbers, num);
            while(countMatches > 1) {
                num = rand.nextInt();
                countMatches = Collections.frequency(arrNumbers, num);
            }
            arrNumbers.add(num);
        }

        return ;
    }

}
