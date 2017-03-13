import parser.FindNumberYAML;
import parser.GenerateNumbers;

public class Main {

    public static void main(String[] args) {

        String fileName = "numbers.yaml";
        int countNumbers = 7;
        FindNumberYAML yaml = new FindNumberYAML (fileName, countNumbers);
        yaml.createYAMLFile();
        yaml.findNumber();
    }
}