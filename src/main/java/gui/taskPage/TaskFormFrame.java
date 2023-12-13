package gui.taskPage;

import entities.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TaskFormFrame extends JPanel
{

//    var id: Int,
//    var description: String,
//    var durationInDays: Int,
//    var successorTasks: MutableList<Task> = mutableListOf()

    // Declare class attributes
    // text fields for adding and removing table elements
    private JTextField NameTextField;
    private JTextField descriptionTextField;
    private JTextField durationInDaysTextfield;

    // declare buttons to add and remove fields
    private JButton addButton;
    private JButton removeButton;
    private JButton addSuccessor;

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
        addButton = new JButton("Add Project");
        removeButton = new JButton("Remove Selected Project");

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
                addTask();
            }
        });

        // listener to remove task object to table
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
    private void addTask()   // Add task object
    {
        // Returns text from nameTextField and assigns to var name
        String name = NameTextField.getText();

        // Returns text from durationInDayText fields and assigns to var as integer
        int days = Integer.parseInt((durationInDaysTextfield.getText())); // Add error handling

        ArrayList<Task> successorTasks = new ArrayList<Task>(); // Create and initialize the ArrayList
        // Creates project object
        Task newTask = new Task(name, days, successorTasks);

        // link task to parent project
//        taskTableModel.addTask(newProject);
//        taskTableModel.addTask();

        // Clear input fields
        NameTextField.setText("");
        descriptionTextField.setText("");
        durationInDaysTextfield.setText("");

    }


    public void removeSelectedProject() // remove selected project object from table
    {
        // assigns selected row to variable as index
        int selectedRowIndex = table.getSelectedRow();
        // if number falls within range of table items, remove
        if (selectedRowIndex >= 0)
        {
            //taskTableModel.(selectedRowIndex);
        }

        else
        {
            JOptionPane.showMessageDialog(this, "Please select a row to remove.");
        }
    }
}



