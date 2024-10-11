package dal;

public class WordDTO {
    private String urduWord;
    private String persianMeaning;
    private String arabicMeaning;

    public WordDTO(String urduWord, String persianMeaning, String arabicMeaning) {
        this.urduWord = urduWord;
        this.persianMeaning = persianMeaning;
        this.arabicMeaning = arabicMeaning;
    }

    public String getUrduWord() {
        return urduWord;
    }

    public void setUrduWord(String urduWord) {
        this.urduWord = urduWord;
    }

    public String getPersianMeaning() {
        return persianMeaning;
    }

    public void setPersianMeaning(String persianMeaning) {
        this.persianMeaning = persianMeaning;
    }

    public String getArabicMeaning() {
        return arabicMeaning;
    }

    public void setArabicMeaning(String arabicMeaning) {
        this.arabicMeaning = arabicMeaning;
    }
}
