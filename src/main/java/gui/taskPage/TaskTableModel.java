package gui.taskPage;

import entities.Project;
import entities.Task;

import javax.swing.table.AbstractTableModel;
import java.util.List;

// table model class, receives updated list of projects, handles logic of task table, is the actual table
public class TaskTableModel extends AbstractTableModel // Class
{
    // Updated list of projects, all project objects contain lists of tasks
    private final List<Project> projects;
    private final String[] columnNames = {"Project:", "Description", "Duration (Days)", "Tasks"};


    public TaskTableModel(List<Project> projects) {
        this.projects = projects;   // passes projects to class level
    }   // Constructor

    @Override
    public int getRowCount() {
        return projects.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }


    // determines what data is displayed where
    // primary purpose is to return the value of what should be displayed in a cell
    // is called whenever it needs to display or refresh information in a cel, is used by Jtable
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Project project = projects.get(rowIndex);
        // i want to display the tasks of a project
        List<Task> taskList = project.getTasks();
        Task taskInfo = taskList.get(rowIndex);
        switch (columnIndex)
        {
            case 0: return project.getName();
            case 1: return "";  // Initially empty
            case 2: return "";  // Initially empty
            case 3: return taskInfo.getDescription();  // Initially empty
            default: throw new IllegalArgumentException("Invalid column index");
        }
    }


    public Project getSelectedProject(int selectedRowIndex)
    {
        // Object of selected project, uses get method which returns project object
        Project selectedProject = projects.get(selectedRowIndex);
        // we have our selected project

        return selectedProject;
    }






}

