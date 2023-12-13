package gui;

import javax.swing.*;
import java.awt.*;

// Main frame of GUI, to be used across all pages
public class MainFrame extends JFrame
{

    // Constructor
    public MainFrame()
    {
        //Add declaration of variables up here at some point
        // Declare and initialise mainFrame
        setLayout(new BorderLayout());

        // Declare and initialise content panels
        JPanel mainPanel = new JPanel();
        JPanel sidePanel = new JPanel();

        // Set title size and close operation
        setTitle("Project Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Customise sidebar panel with a vertical box layout for navigation buttons
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
        sidePanel.setBackground(new Color(64, 0, 128));
        sidePanel.setPreferredSize(new Dimension(150, getHeight())); // Sidebar width

        // Declare and initialise buttons for sidePanel
        JButton mainButton = new JButton("Main");
        JButton projectsButton = new JButton("Projects");
        JButton tasksButton = new JButton("Tasks");
        JButton usersButton = new JButton("Users");

        // Add buttons to the sidePanel
        sidePanel.add(mainButton);
        sidePanel.add(projectsButton);
        sidePanel.add(tasksButton);
        sidePanel.add(usersButton);




        // Style the buttons as needed


        // Main content area - centre of JPanel, to change across pages
        //JPanel mainPanel = new JPanel(new BorderLayout());  // create main panel frame
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Creates table panel object
        ProjectTableModel tableModel = new ProjectTableModel();
        JTable table = new JTable(tableModel);

        // Add table to scroll panel
        JScrollPane scrollPane = new JScrollPane(table);

        // Add sidePanel and content panel to the main frame
        add(sidePanel, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);

        // Add scroll panel to main panel
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        // Display the frame
        setVisible(true);
    }
}