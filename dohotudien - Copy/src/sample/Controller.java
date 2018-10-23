package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public Dictionary dictionary = new Dictionary();
    public DictionaryManagement dictionaryManagement = new DictionaryManagement();
    Stage primarySage;
    @FXML
    public Scene tableView;
    @FXML
    ObservableList<Word> listWord;
    @FXML
    private TableView<Word> table;
    @FXML
    private TableColumn<Word, String> wordColumn;
    @FXML
    private TableColumn<Word, String> meanColumn;
    @FXML
    private TextField wordText;
    @FXML
    private TextField meanText;
    @FXML
    private TextField textSearch;
    @FXML
    private Button buttonAdd;
    @FXML
    Button speech_Button;
    ArrayList<Word> arrayListWord = new ArrayList<Word>();
    private ObservableList<Word> masterData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addFromFile();
        for (int i = 0; i <= dictionaryManagement.countWord; i++) {
            arrayListWord.add(dictionary.words[i]);
        }
        listWord = FXCollections.observableArrayList(arrayListWord);
        wordColumn.setCellValueFactory(new PropertyValueFactory<Word, String>("word"));
        meanColumn.setCellValueFactory(new PropertyValueFactory<Word, String>("mean"));
        table.setItems(listWord);
    }

    public void addFromFile() {
        dictionaryManagement.insertFromFile();
    }

    @FXML
    public void addWordFromText(ActionEvent e) {
        Word newWord = new Word();
        newWord.setWord(wordText.getText());
        newWord.setMean(meanText.getText());
//        dictionary.words
        dictionaryManagement.countWord++;
        dictionary.words[DictionaryManagement.countWord] = newWord;
        arrayListWord.add(newWord);
        listWord = FXCollections.observableArrayList(arrayListWord);
        wordColumn.setCellValueFactory(new PropertyValueFactory<Word, String>("word"));
        meanColumn.setCellValueFactory(new PropertyValueFactory<Word, String>("mean"));
        table.setItems(listWord);
        table.getColumns().clear();
        table.getColumns().addAll(wordColumn, meanColumn);
        wordText.clear();
        meanText.clear();
    }

    public void delete(ActionEvent e) {
        Word selectWord = table.getSelectionModel().getSelectedItem();
        arrayListWord.remove(selectWord);
        listWord.remove(selectWord);
    }

    public void search(ActionEvent event) {
        FilteredList<Word> filteredData = new FilteredList<>(listWord, p -> true);
        textSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(word -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (word.getWord().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (word.getMean().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });
        SortedList<Word> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    }


    public void edit(ActionEvent e) {
        int i = 0; // biến tìm phần vị trí phần tử cần xóa
        Word selectionWord = table.getSelectionModel().getSelectedItem();
        Word newWord = new Word();
        newWord.setWord(wordText.getText());
        newWord.setMean(meanText.getText());
        for (i = 0; i < arrayListWord.size(); i++) {
            if (arrayListWord.get(i).getWord().equals(selectionWord.getWord()))
                break;
        }
        arrayListWord.set(i, newWord);
        listWord = FXCollections.observableArrayList(arrayListWord);
        wordColumn.setCellValueFactory(new PropertyValueFactory<Word, String>("word"));
        meanColumn.setCellValueFactory(new PropertyValueFactory<Word, String>("mean"));
        table.setItems(listWord);
        table.getColumns().clear();
        table.getColumns().addAll(wordColumn, meanColumn);
    }
}

