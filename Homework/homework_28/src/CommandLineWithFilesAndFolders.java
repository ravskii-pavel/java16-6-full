import java.io.*;
import java.util.Scanner;

/**
 * Created by ravskiy on 24.02.2017.
 */
public class CommandLineWithFilesAndFolders {
    private static final String DEFAULT_PATH = "D:\\";
    private static File currentDir = new File(DEFAULT_PATH);

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print(currentDir.getPath() + ">");
            String line = scanner.nextLine();

            if (line.startsWith("print")) {
                if (line.endsWith("ls")) {
                    if (currentDir.isDirectory()) {
                        printAll(currentDir);
                    }
                } else if (currentDir.isDirectory()) {
                    printAllDirectories(currentDir);
                }
            } else if (line.startsWith("mkDir")) {      //mkDir newFolderName
                createNewFolder(line, currentDir);
            } else if (line.startsWith("cd")) {
                changeDirectory(line);
            } else if (line.startsWith("mkFile")) {
                createNewFile(currentDir, line);
            } else if (line.startsWith("delete")) {
                deleteFileOrFolder(currentDir, line);
            } else if (line.startsWith("open")) {
                openTextFile(line);
            } else if (line.startsWith("edit")) {
                editTextFile(line, scanner);
            }else if (line.startsWith("exit")) break;
        }
    }

    private static String openTextFile(String line) throws IOException {
        String filename = line.split("\\s+")[1];
        InputStream input = new FileInputStream(filename);
        StringBuilder result = new StringBuilder();
        int data;
        while ((data = input.read()) >= 0 && (filename.endsWith("txt") || filename.endsWith("csv"))) {
            result.append((char) data);
        }
        input.close();
        System.out.println(result.toString());
        return result.toString();
    }

    public static void editTextFile(String line, Scanner scanner) throws IOException {
        String textFromFile = openTextFile(line);
        String filename = line.split("\\s+")[1];
        String buff = scanner.nextLine();
        while (!buff.equals("save")) {
            textFromFile = textFromFile + "\r\n" + buff;
            buff = scanner.nextLine();
        }
        OutputStream out = new FileOutputStream(filename);
        out.write((textFromFile).getBytes());
        out.close();
    }

        private static void changeDirectory(String line){
            String folderName=line.split("\\s+")[1];
            if(folderName.contains("..")){
                if(currentDir.getParentFile()!=null) currentDir = currentDir.getParentFile();
                return;
            }
            File[]list=currentDir.listFiles(new FileFilter(){
                @Override
                public boolean accept(File dir){
                    return dir.isDirectory()&&dir.getName().contains(folderName);
                }
            });
            if(list.length==1){
                File matchedFolder=list[0];
                currentDir=matchedFolder;
            } else if(list.length==0){
                System.out.println("No such file or directory");
            } else {
                for(File dir:list){
                    System.out.println(dir.getName());
                }
            }
        }

        private static void deleteFileOrFolder(File parent,String line){
            String name=line.split("\\s+")[1];
            File[]files=parent.listFiles();
            for(File f:files){
                if(f.isDirectory()&&!f.isHidden()&&f.getName().equals(name)){
                    f.delete();
                    break;
                }else if((f.isFile()&&f.getName().equals(name))||
                    (f.isFile()&&f.getName().substring(0,f.getName().lastIndexOf('.')).equals(name))){
                    f.delete();
                    break;
                }
            }
        }

        private static void createNewFolder(String line,File parent){
            String folderName=line.split("\\s+")[1];

            File directory=new File(parent,folderName);
            directory.mkdir();
        }

        private static void createNewFile(File parent,String line){
            String fileName=line.split("\\s+")[1];

            File file=new File(parent,fileName);
            try{
                file.createNewFile();
            }catch(IOException e){
                e.printStackTrace();
            }
        }

        private static void printAllDirectories(File file){
            File[]files=file.listFiles();
            for(File f:files){
                if(f.isDirectory()&&!f.isHidden()){
                    System.out.println(f.getName());
                }
            }
        }

        private static void printAll(File file){
        File[]files=file.listFiles();
            for(File f:files){
                System.out.println(f.getName());
            }
        }
}

