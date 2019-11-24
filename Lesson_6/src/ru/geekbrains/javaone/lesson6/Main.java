package ru.geekbrains.javaone.lesson6;
import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    
    public static String createString(int leng){
        String sample = "0123456789ABCDEFGHIGKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder(leng);
        Random rnd = new Random();
        for (int i = 0; i < leng; i++){
            sb.append(sample.charAt(rnd.nextInt(sample.length())));
        }
        return sb.toString();
    }

    public static void createFile(String nameFile){
        int randomLength = ThreadLocalRandom.current().nextInt(50, 100 + 1);
        try (FileWriter writer = new FileWriter(nameFile))
        {
            writer.write(createString(randomLength));
            writer.flush();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        System.out.println(createString(50));

        createFile("1.txt");
        createFile("2.txt");
        glueFiles(new String[]{"1.txt", "2.txt"}, "3.txt");
        searchInFile("shroudextract.txt");

    }


    public static void glueFiles (String[] names, String destinationName){
        try {
            FileOutputStream fileOut = new FileOutputStream(destinationName);

            for (String name : names) {
                FileInputStream fileIn = new FileInputStream(name);
                int i;
                do {
                    i = fileIn.read();
                    if (i != -1) fileOut.write(i);
                }
                while (i != -1);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void searchInFile(String fileName) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите слово для поиска: ");
        String searchQuery = sc.nextLine();

        try{
            FileInputStream fileIn = new FileInputStream(fileName);
            int symbol;
            int index = 0;

            byte[] wordByBytes = searchQuery.getBytes();
            do {
                symbol = fileIn.read();
                if (wordByBytes[index] == symbol) {
                    index++;
                    if (index == wordByBytes.length) {
                        System.out.println("Слово найдено!");
                        break;
                    }
                } else index = 0;
            }
            while (symbol != -1);
            if (index == 0) System.out.println("Слово не найдено.");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        sc.close();
    }

}
