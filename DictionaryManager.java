package bll;

import dal.WordDAO;
import dal.WordDTO;

import javax.swing.*;
import java.util.List;

public class DictionaryManager {
    private WordDAO wordDAO;

    public void setFilePath(String filePath) {
        this.wordDAO = new WordDAO(filePath);
    }

    public List<WordDTO> getAllWords() {
        return wordDAO.getAllWords();
    }
}
