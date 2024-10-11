
package bll;

import dal.DictionaryDAO;
import dto.DictionaryDTO;
import java.util.List;

public class DictionaryService {
    private DictionaryDAO dictionaryDAO;

    public DictionaryService(String filePath) {
        this.dictionaryDAO = new DictionaryDAO(filePath);
    }

    public List<DictionaryDTO> getDictionaryEntries() {
        return dictionaryDAO.readDictionary();
    }
}
