import java.util.Scanner;
import java.lang.*;
import java.util.ArrayList;
import java.io.*;
import java.util.*;


// file hiển thị kết quả
public class DictionaryCommandline {
    public   static Dictionary dictionary;
    public DictionaryManagement dictionaryManagement;
    // object obCOUNT dùng để truy cập vào biến đếm Word(countWord) trong DictonaryManagen
    DictionaryCommandline(){
        dictionary = new Dictionary();
        dictionaryManagement = new DictionaryManagement();
    }


    public void  dictionarySearcher(){ //tìm kiếm từ
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter keyword:");
        String strNeedSearcher = sc.nextLine(); // strNeedSearch là biến lưu keyword cần tra
        System.out.println("|--------------------------------------------------------------------|");
        System.out.printf("|%12s%12s%12s%12s", "WORD", "|", "MEAN", "|");
        System.out.println();
         for(int i = 0; i < dictionary.arrayList.size(); i++){
             if( strNeedSearcher.length() <= dictionary.arrayList.get(i).getWord().length()){
                 if(strNeedSearcher.equals(dictionary.arrayList.get(i).getWord().substring(0,strNeedSearcher.length()))){
                     dictionary.arrayList.get(i).displayWord();
                 }
             }
              if( strNeedSearcher.length() <= dictionary.arrayList.get(i).getMean().length()){
                 if(strNeedSearcher.equals(dictionary.arrayList.get(i).getMean().substring(0,strNeedSearcher.length()))){
                     dictionary.arrayList.get(i).displayWord();
                 }
             }
             else if(i == dictionary.arrayList.size() - 1) System.out.println("Không tìm thấy");
             else continue;
         }

    }

    public void showAllWords() {
        System.out.println("|--------------------------------------------------------------------|");
        System.out.printf("|%12s%12s%12s%12s", "WORD", "|", "MEAN", "|");
        System.out.println();
        for(int i = 0; i < dictionary.arrayList.size(); i++){
            dictionary.arrayList.get(i).displayWord();
        }
        System.out.println("|--------------------------------------------------------------------|");
    }
}