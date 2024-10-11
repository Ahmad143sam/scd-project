package pl;

import bll.DictionaryManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DictionaryApp extends JFrame {
    private DictionaryManager manager;

    public DictionaryApp() {
        manager = new DictionaryManager();
        initWelcomeScreen();
    }

    private void initWelcomeScreen() {
        JPanel panel = new JPanel();
        JLabel welcomeLabel = new JLabel("Welcome to Multilingual Dictionary");
        JButton importButton = new JButton("Import File");

        importButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFileImportScreen();
            }
        });

        panel.add(welcomeLabel);
        panel.add(importButton);
        add(panel);
        setTitle("Multilingual Dictionary");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack(); 
    }

    private void openFileImportScreen() {
        JPanel importPanel = new JPanel();
       
        JButton localFileButton = new JButton("choose file");

        localFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                    manager.setFilePath(filePath);
                    openMainDictionaryScreen();
                } else {
                    JOptionPane.showMessageDialog(null, "File import canceled.");
                }
            }
        });

       
        importPanel.add(localFileButton);

        setContentPane(importPanel);
        revalidate();
        repaint();
    }

    private void openMainDictionaryScreen() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        JButton seeAllButton = new JButton("See All");

        seeAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openDictionaryTable();
            }
        });

        mainPanel.add(seeAllButton, BorderLayout.CENTER);
        setContentPane(mainPanel);
        revalidate();
        repaint();
    }

    private void openDictionaryTable() {
        DictionaryTablePanel tablePanel = new DictionaryTablePanel(manager);
        setContentPane(tablePanel);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            DictionaryApp app = new DictionaryApp();
            app.setVisible(true);
        });
    }
}
