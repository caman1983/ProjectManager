package gui;

import entities.Project;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.Collections;

// Main frame of GUI, to be used across all pages
public class MainFrame extends JFrame
{
    // Class variables

    // Constructor
    public MainFrame()
    {
        // Declare and initialise mainFrame
        setLayout(new BorderLayout());

        // Declare and initialise content panels
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel sidePanel = new JPanel();

        // Main content area - centre of JPanel, to change across pages
        // Customise main content area
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

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



        Project project1 = new Project(("FirstProject"), LocalDate.parse("2001-12-23"), 22.0);

        // Creates table panel object
        ProjectTableModel tableModel = new ProjectTableModel(Collections.singletonList(project1));

        // changes table panel object to JTable
        JTable table = new JTable(tableModel);

        // Add table to scroll panel
        JScrollPane scrollPane = new JScrollPane(table);

        ProjectFormFrame formPanel = new ProjectFormFrame(tableModel, table);
        // Add sidePanel and content panel to the main frame
        add(sidePanel, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);
        add(formPanel, BorderLayout.EAST);
        // Add scroll panel to main panel
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        // Display the frame
        setVisible(true);

    } // End of constructor
}