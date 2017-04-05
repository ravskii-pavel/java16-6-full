package parser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;


public class FindNumberYAML extends GenerateNumbers{

    private int countNumbers;
    public RandomAccessFile file;
    public String fileName;
    private String header = "Numbers: " + "[";
    private String footer = "]";

    public FindNumberYAML(String fileName, int countNumbers) {
        this.countNumbers = countNumbers;
        this.fileName = fileName;
        try {
            this.file = new RandomAccessFile(fileName, "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void createYAMLFile(){
        file = parseToYAML(generateNumbers(this.countNumbers));
    }

    public void findNumber(){
        System.out.println(searchNumber(readFromYAML()));
    }

    public RandomAccessFile parseToYAML (ArrayList<Integer> list){

        try {
            file.setLength(0L);
            file.seek(0L);
            file.write(header.getBytes());
            for(int i = 0; i < list.size(); i++){
                file.write(String.valueOf(list.get(i)).getBytes());
                if(!(i == list.size()-1)) file.write(", ".getBytes());
            }
            file.write(footer.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public ArrayList<Integer> readFromYAML(){

        ArrayList<Integer> list = new ArrayList();
        try {
            int i = 0;
            file.seek(header.length());
            String str = file.readLine();
            str = str.substring(0, str.length()-1);
            String[] params = str.split(", ");
            while (i < params.length) {
                list.add(Integer.parseInt(params[i]));
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  list;
    }

}
