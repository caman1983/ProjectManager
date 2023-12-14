package gui.taskPage;

import entities.Project;
import entities.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// TaskFormFrame class, handles visual components, is the actual frame
public class TaskFormFrame extends JPanel
{
    // Declare class attributes
    // text fields for adding and removing table elements
    private JTextField NameTextField;
    private JTextField descriptionTextField;
    private JTextField durationInDaysTextfield;

    // declare buttons to add and remove fields
    private JButton addButton;
    private JButton OpenSuccessorTaskTableButton;
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
        addButton = new JButton("Add Task to selected project");
        OpenSuccessorTaskTableButton = new JButton("View task list of project");

        // Add components to the panel
        add(new JLabel("Task Name:"));
        add(NameTextField);

        add(new JLabel("Task description:"));
        add(descriptionTextField);

        add(new JLabel("Duration in days:"));
        add(durationInDaysTextfield);

        add(addButton);
        add(OpenSuccessorTaskTableButton);


        // Action listeners

        // listener to add task object to table
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTaskToSelectedProject();
            }
        });


        OpenSuccessorTaskTableButton.addActionListener(new ActionListener()  // listener to view task list table
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                viewSuccessorTaskTable(); // opens task table
            }
        });
    }   // end of constructor


    // Methods
    private void addTaskToSelectedProject()   //
    {
        // Returns text from name text field and assigns to var name
        String name = NameTextField.getText();

        // Returns text from duration in days text field and assigns to var as integer
        int days = Integer.parseInt((durationInDaysTextfield.getText())); // Add error handling

        // selectedProject = project object at selected row
        Project selectedProject = taskTableModel.getSelectedProject(getSelectedRowIndex());

        // empty list of successor tasks for new task
        //ArrayList<Task> emptyListOfSuccessorTasks = new ArrayList<Task>();

        Task newTask = new Task(name, days);
        System.out.println("Before: "+selectedProject.getTasks());

        // new task list!!
        selectedProject.addTask(newTask);
        System.out.println("After: "+selectedProject.getTasks());
        // Clear input fields
        NameTextField.setText("");
        descriptionTextField.setText("");
        durationInDaysTextfield.setText("");

    }


    // Returns selected row index as integer
    public int getSelectedRowIndex()
    {
        int selectedRowIndex = table.getSelectedRow();

        if(selectedRowIndex == -1)
        {
            selectedRowIndex = 0;
        }
        return selectedRowIndex;
    }

    public void viewSuccessorTaskTable() // button to view task table of selected row
    {
        // updated project object, hopefully
        Project selectedProject = taskTableModel.getSelectedProject(getSelectedRowIndex());

        //pass selected project into successor task model
        SuccessorTasksModel successorTasksModel = new SuccessorTasksModel(selectedProject);

        // actual table
        JTable successorTasksTable = new JTable(successorTasksModel);
        JScrollPane successorScrollPane = new JScrollPane(successorTasksTable); // Add table to a scroll pane for better usability

        JLabel infoLabel = new JLabel("Tasks appear in their respective order of completion");
        JFrame frame = new JFrame("Tasks Table");

        frame.setLayout(new BorderLayout()); // Set layout manager
        frame.add(successorScrollPane); // Add the scroll pane to the frame
        frame.setSize(400, 300); // Set the size of the frame

        frame.add(infoLabel, BorderLayout.NORTH); // Add label at the top of the frame
        frame.add(successorScrollPane, BorderLayout.CENTER); // Add the table in the center
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Set default close operation
        frame.setVisible(true); // Make sure the frame is visible
    }
}



