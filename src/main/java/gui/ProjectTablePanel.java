package gui;

import javax.swing.*;
// Class for table panel
public class ProjectTablePanel extends JPanel
{
    // class variables
    // string table of column names
    String[] columnNames = {"Project ID", "Budget"};

    // Table using data object
    // No idea why this works yet
    Object[][] data = {}; // Placeholder for actual data
    JTable table = new JTable(data, columnNames);

    // Creates tablePane object
    JScrollPane tablePane = new JScrollPane(table);



}
//ø