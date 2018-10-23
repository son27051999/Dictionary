public class Word {
    private String word;
    private String mean;
    Word(){
    }
    Word(String word, String mean){
        this.word= word;
        this.mean = mean;
    }

    public String getWord(){
        return word;
    }

    public String getMean(){
        return mean;
    }

    public void setWord(String word){
        this.word = word;
    }

    public void setMean(String mean){
        this.mean = mean;
    }

    public void displayWord(){
        System.out.println("|--------------------------------------------------------------------|");
        System.out.printf("|%12s%12s%12s%12s", word, "|", mean, "|");
        System.out.println();
    }

}