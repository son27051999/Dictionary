package sample;

import java.util.Scanner;
import java.io.*;

public class DictionaryManagement {
    static Scanner sc = new Scanner(System.in);
    final static int m = 1000;
    public static int countWord = -1; // biến đếm số từ trong mảng từ điển;
    static Dictionary dictionary = new Dictionary();
    static DictionaryCommandline word = new DictionaryCommandline();

    DictionaryManagement() {
    }

    public void insertFromFile() {   // đọc dữ liệu từ file
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt"),
                    "Unicode"));
            String textInALine;
            while ((textInALine = br.readLine()) != null) {
                String[] subStr = textInALine.split("\t", 2);
                countWord++;
                // subStr : cai nay chi co 1 phan tu trong mang, ko co subStr[1]

                dictionary.input(subStr[0], subStr[1], countWord);
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
}