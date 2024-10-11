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
 
    
}
