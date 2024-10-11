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
 //------------crud   
 public void addWordDialog() {
        JTextField urduField = new JTextField();
        JTextField persianField = new JTextField();
        JTextField arabicField = new JTextField();

        Object[] message = {
            "Urdu Word:", urduField,
            "Persian Meaning:", persianField,
            "Arabic Meaning:", arabicField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Add Word", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            WordDTO word = new WordDTO(urduField.getText(), persianField.getText(), arabicField.getText());
            wordDAO.addWord(word);
        }
    }

    public void updateWordDialog(String urduWord) {
        WordDTO word = wordDAO.getAllWords().stream()
            .filter(w -> w.getUrduWord().equals(urduWord))
            .findFirst().orElse(null);

        if (word != null) {
            JTextField persianField = new JTextField(word.getPersianMeaning());
            JTextField arabicField = new JTextField(word.getArabicMeaning());

            Object[] message = {
                "Persian Meaning:", persianField,
                "Arabic Meaning:", arabicField
            };

            int option = JOptionPane.showConfirmDialog(null, message, "Update Word", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                word.setPersianMeaning(persianField.getText());
                word.setArabicMeaning(arabicField.getText());
                wordDAO.updateWord(word);
            }
        }
    }

    public void deleteWord(String urduWord) {
        wordDAO.deleteWord(urduWord);
    }
}
