package FileHandling;

import java.io.*;
import java.util.Scanner;

public class FileOperation {
    public static void main(String[] args) {
        File file = createFileifNotExist();
        showFileInfo(file);
//        file = writeToFile(file);
        String fileInfo = getFileData(file);
    }

    private static String getFileData(File file) {
        try{
            Scanner sc = new Scanner(file);
            int line=0;
            while (sc.hasNextLine()){
                line++;
                String data[] = sc.nextLine().trim().split(",");
                for(int i =0 ;i<data.length;i++){
                    String str = data[i];
                    if(data[i].trim().isEmpty()){
//                        throw new Exception("data has null at line :"+line);
                        System.out.println("\ndata has null at line :"+line);
                        break;
                    }
                    System.out.print(data[i]+" ");
                }
                System.out.println();
            }
        } catch (Exception e){
            System.out.println("\nexception occured in reading file data :"+e);
        }
        return null;
    }

    private static File writeToFile(File file) {
        try{
            FileWriter writer = new FileWriter(file);
            writer.append("this is apending new data");
//            writer.write("this is file created using java file writer , to test the file operations");
            writer.close();
            System.out.println("write operation performed");
        } catch (Exception e){
            System.out.println("exception occured in writing file"+file+"\n");
        }
        return file;
    }

    private static void showFileInfo(File file) {
        try{
            if (file.exists()){
                System.out.println("canRead :"+file.canRead());
                System.out.println("canWrite :"+file.canWrite());
                System.out.println("canExecute :"+file.canExecute());
                System.out.println("absolutePath :"+file.getAbsolutePath());
                System.out.println("fileName"+file.getName()+"\n");
            }
        } catch (Exception e){
            System.out.println("error occured"+e);
        }
    }

    private static File createFileifNotExist() {
        try{
            File new_file = new File("C:\\xiaomi_workspace\\450dsa\\src\\FileHandling\\file102.txt");
            if(new_file.createNewFile()){
                System.out.println("file created : "+new_file.getName()+"\n");
            }
            else {
                System.out.println("file already exist\n"+new_file.getName());
            }
            return new_file;
        } catch (Exception e){
            System.out.println("error occured :"+e);
        }
        return null;
    }

}
