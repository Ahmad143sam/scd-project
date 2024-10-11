package pl;

import bll.DictionaryManager;
import dal.WordDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DictionaryTablePanel extends JPanel {
    private JTable table;
    private DictionaryManager manager;
    private String[][] data; // Array to hold the word data

    public DictionaryTablePanel(DictionaryManager manager) {
        this.manager = manager;
        setLayout(new BorderLayout());

        // 
        String[] columns = {"Urdu Word", "Persian Meaning", "Arabic Meaning"};
        loadData(); 
        table = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

    } 
   
    private void loadData() {
        List<WordDTO> words = manager.getAllWords();
        data = new String[words.size()][3];
        for (int i = 0; i < words.size(); i++) {
            WordDTO word = words.get(i);
            data[i][0] = word.getUrduWord();
            data[i][1] = word.getPersianMeaning();
            data[i][2] = word.getArabicMeaning();
        }
    }

   
    private void refreshTable() {
        loadData(); 
        table.setModel(new javax.swing.table.DefaultTableModel(data, new String[]{"Urdu Word", "Persian Meaning", "Arabic Meaning"}));
    }

   
    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
