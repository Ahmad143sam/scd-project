package dal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WordDAO {
    private String filePath;

    public WordDAO(String filePath) {
        this.filePath = filePath;
    }

    //To  Read  words
    public List<WordDTO> getAllWords() {
        List<WordDTO> words = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                words.add(new WordDTO(values[0], values[1], values[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }
    // Add a new word to CSV file
    public void addWord(WordDTO word) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(word.getUrduWord() + "," + word.getPersianMeaning() + "," + word.getArabicMeaning() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Update an existing word in CSV
    public void updateWord(WordDTO word) {
        List<WordDTO> words = getAllWords();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (WordDTO w : words) {
                if (w.getUrduWord().equals(word.getUrduWord())) {
                    bw.write(word.getUrduWord() + "," + word.getPersianMeaning() + "," + word.getArabicMeaning() + "\n");
                } else {
                    bw.write(w.getUrduWord() + "," + w.getPersianMeaning() + "," + w.getArabicMeaning() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Delete a word from CSV file
    public void deleteWord(String urduWord) {
        List<WordDTO> words = getAllWords();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (WordDTO w : words) {
                if (!w.getUrduWord().equals(urduWord)) {
                    bw.write(w.getUrduWord() + "," + w.getPersianMeaning() + "," + w.getArabicMeaning() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
}
