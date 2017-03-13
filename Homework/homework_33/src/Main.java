import parser.FindNumberYAML;
import parser.GenerateNumbers;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        String fileName = "numbers.yaml";
        int countNumbers = 7;
        FindNumberYAML yaml = new FindNumberYAML (fileName, countNumbers);
        yaml.createYAMLFile();
        yaml.readFromYAML();
        //createYAML.generationNumbers(35);

        //yaml.searchNumber();

    }
}