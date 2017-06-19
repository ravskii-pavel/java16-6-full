package ua.dp.levelup;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;

/**
 * Created by java on 17.02.2017.
 */
public class Main {

/*input output stream*/
    public static void main(String[] args) throws IOException {
/*        OutputStream out = new FileOutputStream("file.txt");

        out.write("Hello World\r\nnew line".getBytes());
        out.close();*/
        String fileName = "input.txt";
        String fileData = readFromFile(fileName);
        System.out.println(fileData);

        writeToFile(fileData, "output.txt");
    }

    public static String readFromFile(String fileName) throws IOException {

        InputStream input = new FileInputStream(fileName);
        StringBuilder result = new StringBuilder();
        int data;
        while ((data = input.read()) >= 0){
            result.append((char) data);
        }
        input.close();
        return result.toString();
    }

    public static void writeToFile(String data, String fileName)  {

        try (Writer out = new FileWriter(fileName);) {
            out.write(data.toUpperCase());
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
