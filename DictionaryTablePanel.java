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
      // Buttons for Add, Update, Delete
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Word");
        JButton updateButton = new JButton("Update Word");
        JButton deleteButton = new JButton("Delete Word");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to add a new word
                manager.addWordDialog();
                refreshTable(); // Refresh the table after adding
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to update the selected word
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String urduWord = (String) table.getValueAt(selectedRow, 0);
                    manager.updateWordDialog(urduWord);
                    refreshTable(); // Refresh the table after updating
                } else {
                    showMessage("Please select a word to update.");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to delete the selected word
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String urduWord = (String) table.getValueAt(selectedRow, 0);
                    int confirm = JOptionPane.showConfirmDialog(
                            null,
                            "Are you sure you want to delete " + urduWord + "?",
                            "Confirm Delete",
                            JOptionPane.YES_NO_OPTION
                    );
                    if (confirm == JOptionPane.YES_OPTION) {
                        manager.deleteWord(urduWord);
                        refreshTable(); // Refresh the table after deletion
                    }
                } else {
                    showMessage("Please select a word to delete.");
                }
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        add(buttonPanel, BorderLayout.SOUTH);
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
