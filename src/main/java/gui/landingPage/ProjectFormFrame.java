package gui.landingPage;

import entities.Project;
import entities.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProjectFormFrame extends JPanel
{
    // Declare class attributes
    // text fields for adding and removing table elements
    private JTextField nameTextField;
    private JTextField deadlineTextField;
    private JTextField budgetTextField;
    private JTextField idTextField;

    // declare buttons to add and remove fields
    private JButton addButton;
    private JButton removeButton;

    // table model object
    private ProjectTableModel tableModel;


    // Not sure
    private JTable table;


    // Constructor
    public ProjectFormFrame(ProjectTableModel tableModel, JTable table)  // Constructor
    {
        // set layout for frame
        setLayout(new GridLayout(0, 2));

        // passes table model object to class level
        this.tableModel = tableModel;
        this.table = table;

        // Initialise components
        nameTextField = new JTextField(20);
        deadlineTextField = new JTextField(10);
        budgetTextField = new JTextField(10);
        addButton = new JButton("Add Project");
        removeButton = new JButton("Remove Selected Project");

        // Add components to the panel
        // Add components to the paneli
        add(new JLabel("Name:"));
        add(nameTextField);

        add(new JLabel("Deadline (YYYY-MM-DD):"));
        add(deadlineTextField);

        add(new JLabel("Budget:"));
        add(budgetTextField);

        add(addButton);
        add(removeButton);


        // Action listeners

        // listener to add project object to table
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProject();
            }
        });

        // listener to remove project object to table
        removeButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                removeSelectedProject();
            }
        });
    }   // end of constructor


        // Methods
        private void addProject()   // Add project object
        {
            // Returns text from nameTextField and assigns to var name
            String name = nameTextField.getText();
            LocalDate deadline = LocalDate.parse(deadlineTextField.getText()); // Add error handling
            double budget = Double.parseDouble(budgetTextField.getText()); // Add error handling

            ArrayList<Task> tasks = new ArrayList<Task>(); // Create and initialize the ArrayList
            // Creates project object

            Project newProject = new Project(name, deadline, budget, tasks);
            tableModel.addProject(newProject);
            // Clear input fields
            nameTextField.setText("");
            deadlineTextField.setText("");
            budgetTextField.setText("");

        }


        public void removeSelectedProject() // remove selected project object from table
        {
            // assigns selected row to variable as index
            int selectedRowIndex = table.getSelectedRow();
            // if number falls within range of table items, remove
            if (selectedRowIndex >= 0){tableModel.removeProject(selectedRowIndex);}

            else{JOptionPane.showMessageDialog(this, "Please select a row to remove.");}
        }
}



