package gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame
{
    // Main frame of GUI, to be used across all pages
    public MainFrame()
    {
        setTitle("Project Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Sidebar panel with a vertical box layout for navigation buttons
        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
        sidePanel.setBackground(new Color(64, 0, 128)); // Adjust the color as needed
        sidePanel.setPreferredSize(new Dimension(150, getHeight())); // Sidebar width

        // Adding buttons to the sidePanel
        JButton mainButton = new JButton("Main");
        JButton projectsButton = new JButton("Projects");
        JButton tasksButton = new JButton("Tasks");
        JButton usersButton = new JButton("Users");

        // Style the buttons as needed

        // Add buttons to the sidePanel
        sidePanel.add(mainButton);
        sidePanel.add(projectsButton);
        sidePanel.add(tasksButton);
        sidePanel.add(usersButton);

        // Main content area - centre of JPanel, to change across pages
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Creates table panel object
        ProjectTablePanel table = new ProjectTablePanel();

        // Add the scroll pane containing the table to the content panel
        mainPanel.add(table.tablePane, BorderLayout.CENTER);

        // Add sidePanel and content panel to the frame
        add(sidePanel, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);

        // Display the frame
        setVisible(true);
    }
}