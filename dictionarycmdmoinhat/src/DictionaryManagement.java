import java.util.Scanner;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import java.util.*;

public class DictionaryManagement {
    static Scanner sc = new Scanner(System.in);
    final static int m = 1000;
    public static int  countWord = -1; // biến đếm số từ trong mảng từ điển;
    static Dictionary dictionary = new Dictionary();
    static DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
    DictionaryManagement(){
    }

    public static void menu() { //HIỂN THỊ MENU
        System.out.println("1.Add Word");
        System.out.println("2.Search");
        System.out.println("3.List All");
        System.out.println("4.Nhập dữ liệu từ file:");
        System.out.println("5.Edit:");
        System.out.println("6.Delete:");
        System.out.println("7.Ghi ra file");
        System.out.println("8.Exit");
    }

    public static void dictionaryLookUp(){
        System.out.print("Enter your word:");
        String wordSearch = sc.nextLine();
        for(int i = 0; i < dictionary.arrayList.size(); i++){
            if(dictionary.arrayList.get(i).getWord().equals(wordSearch) || dictionary.arrayList.get(i).getMean().equals(wordSearch)){
                System.out.println("|--------------------------------------------------------------------|");
                System.out.printf("|%12s%12s%12s%12s", "WORD", "|", "MEAN", "|");
                System.out.println();
                dictionary.arrayList.get(i).displayWord();
                break;
            }
            else if(i == dictionary.arrayList.size() - 1 ) System.out.println("Không tìm thấy");
        }
    }

    public static void Delete() {
        System.out.println("Nhập từ cần delete");
        System.out.print("Word:");
        String wordDelete = sc.nextLine();
        System.out.print("Mean:");
        String meanDelete = sc.nextLine();
        for(int i = 0; i < dictionary.arrayList.size(); i++){
            if(dictionary.arrayList.get(i).getWord().equals(wordDelete) ||dictionary.arrayList.get(i).getMean().equals(meanDelete)){
               dictionary.arrayList.remove(dictionary.arrayList.get(i));
               break;
            }
        }
    }

    public static void Edit(){
        System.out.print("Nhập từ cần edit:");
        String wordEdit = sc.nextLine();
        for(int i = 0; i < dictionary.arrayList.size(); i++){
            if(dictionary.arrayList.get(i).getWord().equals(wordEdit) || dictionary.arrayList.get(i).getMean().equals(wordEdit)){
                System.out.print("New Word:");
                dictionary.arrayList.get(i).setWord(sc.nextLine());
                System.out.print("New Mean:");
                dictionary.arrayList.get(i).setMean(sc.nextLine());
                break;
            }
            else if(i == dictionary.arrayList.size() - 1 ) System.out.println("Không tìm thấy");
        }
    }

    public static void insertFromFile(){   // đọc dữ liệu từ file
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream("dictionary.txt"),
                    "Unicode"));
            String textInALine;
            while ((textInALine = br.readLine()) != null) {
                    String[] subStr = textInALine.split("\t", 2);
                    dictionary.arrayList.add(new Word(subStr[0], subStr[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void insertFromCommandline() {  // ADD WORD
        terminate:
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Word:");
            String word = sc.nextLine();
            System.out.print("Mean:");
            String mean = sc.nextLine();
            dictionary.arrayList.add(new Word(word,mean));
            while (true) {
                System.out.print("Nhập Y để tiếp tục, N để thoát:");
                String NY = sc.next();
                if (NY.equals("N")) break terminate;
                else if (NY.equals("Y")) {
                    countWord++;
                    break;
                } else {
                    System.out.println("Nhập chưa chính xác mời nhập lại.");
                    continue;
                }
            }
        }
    }

    public static void dictionaryExportToFile(){
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            String content = "This is the content to write into file\n";

            fw = new FileWriter("output.txt");
            bw = new BufferedWriter(fw);
            for(int i = 0; i < dictionary.arrayList.size();i++) {
                bw.write(dictionary.arrayList.get(i).getWord() + "\t" + dictionary.arrayList.get(i).getMean() + "\r\n");
            }
                System.out.println("Done");


        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

    }



    public static void option() {
        Scanner sc = new Scanner(System.in);
        boolean  a = true;
        while (a == true) {
            menu();
            System.out.print("Option:");
             int  luaChon = sc.nextInt();
            switch (luaChon) {
                case 1:
                    countWord++;
                    insertFromCommandline();
                    break;
                case 2:
                    dictionaryCommandline.dictionarySearcher();
                    break;
                case 3:
                    dictionaryCommandline.showAllWords();
                    break;
                case 4:
                    insertFromFile();
                    break;
                case 5:
                    Edit();
                    break;
                case 6:
                    Delete();
                    break;
                case 7:
                    dictionaryExportToFile();
                    break;
                case 8:
                    a = false;
                    break;
                default:
                    System.out.println("Nhập sai mời nhập lại");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        DictionaryManagement td = new DictionaryManagement();
        td.option();
    }
}
 