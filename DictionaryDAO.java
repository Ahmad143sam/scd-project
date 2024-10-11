
package dal;

import dto.DictionaryDTO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DictionaryDAO {
    private String filePath;

    public DictionaryDAO(String filePath) {
        this.filePath = filePath;
    }

    public List<DictionaryDTO> readDictionary() {
        List<DictionaryDTO> dictionaryEntries = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    DictionaryDTO entry = new DictionaryDTO(parts[0], parts[1], parts[2]);
                    dictionaryEntries.add(entry);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return dictionaryEntries;
    }
}
