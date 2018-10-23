package sample;

import java.lang.String;

public class Dictionary {
    final static int n = 1000;
    public static Word words[];

    Dictionary() {
        words = new Word[n];
    }

    Dictionary(String word, String mean, int count){
        words[count] = new Word(word, mean);
    }

    public static int lengthWord() { // TRẢ LẠI ĐỘ DÀI MẢNG WORDS
        return words.length;
    }

    public void input(String word, String mean, int count) { // KHỞI TẠO MẢNG WORD
        words[count] = new Word(word, mean);
    }
}