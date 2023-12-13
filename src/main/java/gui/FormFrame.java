//package gui;
//
//import entities.Project;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.time.LocalDate;
//
//public class FormFrame extends JPanel
//{
//    // Declare class attributes
//    private JTextField nameTextField;
//    private JTextField deadlineTextField;
//    private JTextField budgetTextField;
//    private JButton addButton;
//    private ProjectTableModel tableModel;
//
//    public void ProjectFormPanel(ProjectTableModel tableModel) {
//        this.tableModel = tableModel;
//
//        setLayout(new GridLayout(4, 2, 5, 5)); // 4 rows, 2 columns layout
//
//        // Initialize attributes
//        nameTextField = new JTextField(20);
//        deadlineTextField = new JTextField(10);
//        budgetTextField = new JTextField(10);
//        addButton = new JButton("Add Project");
//
//        // Add components to the panel
//        add(new JLabel("Name:"));
//        add(nameTextField);
//        add(new JLabel("Deadline (YYYY-MM-DD):"));
//        add(deadlineTextField);
//        add(new JLabel("Budget:"));
//        add(budgetTextField);
//        add(new JLabel()); // Empty label for layout
//        add(addButton);
//
//        // Button action
//        addButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                addProject();
//            }
//        });
//    }

//    private void addProject() {
//        String name = nameTextField.getText();
//        LocalDate deadline = LocalDate.parse(deadlineTextField.getText());
//        double budget = Double.parseDouble(budgetTextField.getText());
//
//        Project newProject = new Project(name, deadline, budget);
//        tableModel.addProject(newProject);
//
//        // Optionally, clear the text fields after adding
//        nameTextField.setText("");
//        deadlineTextField.setText("");
//        budgetTextField.setText("");
//    }
//}
