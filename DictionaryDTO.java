
package dto;

public class DictionaryDTO {
    private String urduWord;
    private String persianMeaning;
    private String arabicMeaning;

    public DictionaryDTO(String urduWord, String persianMeaning, String arabicMeaning) {
        this.urduWord = urduWord;
        this.persianMeaning = persianMeaning;
        this.arabicMeaning = arabicMeaning;
    }

    public String getUrduWord() {
        return urduWord;
    }

    public String getPersianMeaning() {
        return persianMeaning;
    }

    public String getArabicMeaning() {
        return arabicMeaning;
    }
}
