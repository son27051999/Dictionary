package sample;

import java.util.Scanner;
import java.lang.*;
import java.io.*;
import java.util.*;


// file hiển thị kết quả
public class DictionaryCommandline {
    public   static Dictionary obWord;
    public DictionaryManagement obCount;
    // object obCOUNT dùng để truy cập vào biến đếm Word(countWord) trong DictonaryManagen
    DictionaryCommandline(){
        obWord = new Dictionary();
        obCount = new DictionaryManagement();
    }

    public void  dictionarySearcher(){ //tìm kiếm từ
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter keyword:");
        String strNeedSearcher = sc.nextLine(); // strNeedSearch là biến lưu keyword cần tra

    }

    public void showAllWords() {
        System.out.println("|--------------------------------------------------------------------|");
        System.out.printf("|%12s%12s%12s%12s", "WORD", "|", "MEAN", "|");
        System.out.println();
    }
}