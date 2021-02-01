package ua.mainacademy.servise;

import ua.mainacademy.model.ConnectionInfo;

import java.io.*;
import java.net.URI;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    //private static final String MAIN_DIR="C:\\221220-Язык программирования Java v.2.4\\lesson-5-work-with-file";
    private static final String MAIN_DIR = System.getProperty("user.dir");
    private static final String SEPARATOR = System.getProperty("file.separator");
    private static final String FILES_DIR = MAIN_DIR + SEPARATOR + "files";

    public static void writeConnectionInfoToFile(ConnectionInfo connectionInfo, String fileName) {

        //write text to file
        checkFileDir();
        String filePath = FILES_DIR + SEPARATOR + fileName;
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(connectionInfo.toString() + "\n");
            fileWriter.flush();

//        FileWriter fileWriter = null;
//
//        try {
//            fileWriter = new FileWriter(filePath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//        }finally {
//            try {
//                fileWriter.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void checkFileDir() {
        File file = new File(FILES_DIR);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    public static List<ConnectionInfo> readConnectionInfoFromFile(String fileName) {

        List<ConnectionInfo> result = new ArrayList<>();

        String filePath = FILES_DIR + SEPARATOR + fileName;
        if (isNotExist(filePath)) {
            throw new RuntimeException("Sorry, can not handle riding");
        }
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] elements = line.split(" ");

                ConnectionInfo connectionInfo = new ConnectionInfo(
                        Integer.valueOf(elements[0]),
                        Long.valueOf(elements[1]),
                        elements[2]
                );

                result.add(connectionInfo);

            }


//            FileReader fileReader=new FileReader(filePath);
//            BufferedReader bufferedReader=new BufferedReader(fileReader);

        } catch (IOException e) {//FileNotFoundException  subordinate IOException
            e.printStackTrace();

//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
        }
        return result;
    }

    private static boolean isNotExist(String filePath) {
        File file = new File(filePath);
        return !file.exists();
    }

    //write method
    public static void writeBytesToFile(byte[] bytes, String fileName) {
        checkFileDir();
        String filePath = FILES_DIR + SEPARATOR + fileName;

        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {

            fileOutputStream.write(bytes);
            fileOutputStream.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //read method
    public static byte[] readBitesFromFile(String fileName) {

        String filePath = FILES_DIR + SEPARATOR + fileName;
        if (isNotExist(fileName)) {
            throw new RuntimeException("Sorry, can not handle riding");
        }

        File file = new File(fileName);
        byte[] bytes = new byte[0];

        try {
            bytes = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    //write from source to target(copy file)
    public static void copyFile(String sourceFile, String targetFile) {
        byte[] bytes = readBitesFromFile(sourceFile);
        writeBytesToFile(bytes, targetFile);

    }

    //moving files or cut-paste
    public static void moveFile(String sourceFile, String targetFile) {
        String filePath = FILES_DIR + SEPARATOR + sourceFile;
        byte[] bytes = readBitesFromFile(sourceFile);
        writeBytesToFile(bytes, targetFile);

        File file=new File(filePath);
        file.delete();
    }
}
