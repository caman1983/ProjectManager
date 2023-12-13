package gui.landingPage;

import entities.Project;
import entities.Task;
import gui.taskPage.TaskTableModel;
//import gui.taskPage.TasksPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Main frame of GUI, to be used across all pages
public class LandingFrame extends JFrame
{
    // Class variables
    // Declare and initialise empty array list of project objects
    ArrayList<Project> projects = new ArrayList<>();
    ArrayList<Task> tasks = new ArrayList<>();

    // Constructor
    public LandingFrame()
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
        JButton projectsButton = new JButton("Projects");
        JButton tasksButton = new JButton("Tasks");
        JButton usersButton = new JButton("Users");

        // Add buttons to the sidePanel
        sidePanel.add(projectsButton);
        sidePanel.add(tasksButton);
        sidePanel.add(usersButton);

        // button styling
        tasksButton.setBackground(new Color(64, 0, 128));
        usersButton.setBackground(new Color(64, 0, 128));
        projectsButton.setBackground(new Color(64, 0, 128));
        tasksButton.setForeground(Color.WHITE);
        usersButton.setForeground(Color.WHITE);
        projectsButton.setForeground(Color.WHITE);

        projectsButton.setOpaque(true);
        projectsButton.setContentAreaFilled(true);
        projectsButton.setBorderPainted(false);
        projectsButton.setFocusPainted(false);

        usersButton.setOpaque(true);
        usersButton.setContentAreaFilled(true);
        usersButton.setBorderPainted(false);
        usersButton.setFocusPainted(false);

        tasksButton.setOpaque(true);
        tasksButton.setContentAreaFilled(true);
        tasksButton.setBorderPainted(false);
        tasksButton.setFocusPainted(false);


        //Project project1 = new Project(("FirstProject"), LocalDate.parse("2001-12-23"), 22.0);

        // Creates table panel object
        ProjectTableModel tableModel = new ProjectTableModel(projects);

        // changes table panel object to JTable
        JTable table = new JTable(tableModel);

        // Add table to scroll panel
        JScrollPane scrollPane = new JScrollPane(table);


        ProjectFormFrame formPanel = new ProjectFormFrame(tableModel, table);

        // Add sidePanel and content panel to the main frame
        add(sidePanel, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);


        // Add scroll panel to main panel
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(formPanel, BorderLayout.EAST);
        // Display the frame
        setVisible(true);


        // changes to TaskFormFrame
        tasksButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();

                // Create a new TaskTableModel and JTable
                TaskTableModel taskTableModel = new TaskTableModel(tableModel.updateProjects());
                JTable tasksTable = new JTable(taskTableModel);

                // Add the table to a JScrollPane
                JScrollPane tasksScrollPane = new JScrollPane(tasksTable);
                tasksScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                tasksScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

                // Add the scroll pane (with the table) to the mainPanel
                mainPanel.add(tasksScrollPane, BorderLayout.CENTER);

                // Revalidate and repaint the panel to update the UI
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });

        // returns back to LandingFrame when clicking projects button
        projectsButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();

                mainPanel.add(scrollPane, BorderLayout.CENTER);
                mainPanel.add(formPanel, BorderLayout.EAST);

                // Revalidate and repaint the panel to update the UI
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });


    } // End of constructor


}