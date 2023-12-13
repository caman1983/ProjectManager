package gui.taskPage;

import entities.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TaskFormFrame extends JPanel {
    // Declare class attributes
    // text fields for adding and removing table elements
    private JTextField NameTextField;
    private JTextField descriptionTextField;
    private JTextField durationInDaysTextfield;

    // declare buttons to add and remove fields
    private JButton addButton;
    private JButton removeButton;
    private JButton addSuccessor; //this button should open a table of successor tasks

    // table model object
    private TaskTableModel taskTableModel;

    // Not sure
    private JTable table;


    // Constructor
    public TaskFormFrame(TaskTableModel tableModel, JTable table)  // Constructor
    {
        // set layout for frame
        setLayout(new GridLayout(0, 2));

        // passes table model object to class level
        this.taskTableModel = tableModel;
        this.table = table;

        // Initialise components
        NameTextField = new JTextField(20);
        descriptionTextField = new JTextField(10);
        durationInDaysTextfield = new JTextField(10);
        addButton = new JButton("Add Task");
        removeButton = new JButton("Remove Selected Selected task, (will remove all sub-tasks");

        // Add components to the panel
        add(new JLabel("Task Name:"));
        add(NameTextField);

        add(new JLabel("Task description:"));
        add(descriptionTextField);

        add(new JLabel("Duration in days:"));
        add(durationInDaysTextfield);

        add(addButton);
        add(removeButton);


        // Action listeners

        // listener to add task object to table
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTaskToSelectedRow();
            }
        });
    }


    // Methods
    private void addTaskToSelectedRow()   // Add task object
    {
        System.out.println("adding task...");
        // Returns text from nameTextField and assigns to var name
        String name = NameTextField.getText();

        // Returns text from durationInDayText fields and assigns to var as integer
        int days = Integer.parseInt((durationInDaysTextfield.getText())); // Add error handling

        // Returns selected row index as integer
        int selectedRowIndex = table.getSelectedRow();

        // Create and initialize empty arrayList of successor tasks
        ArrayList<Task> successorTasks = new ArrayList<Task>();

        // if number falls within range of table items, remove
//        if (selectedRowIndex >= 0)
//        {
            // WHY PLUS ONE?
            taskTableModel.addTask(new Task(name, days, successorTasks), selectedRowIndex + 1);


        // Clear input fields
        NameTextField.setText("");
        descriptionTextField.setText("");
        durationInDaysTextfield.setText("");

    }
//        else{JOptionPane.showMessageDialog(this, "Please select a row to remove.");}


}




