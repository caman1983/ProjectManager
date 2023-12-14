package gui.taskPage;

import entities.Project;
import entities.Task;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class SuccessorTasksModel extends AbstractTableModel
{
    // Updated list of projects, all project objects contain lists of tasks
    private Project project;
    private final String[] columnNames = {"Description:", "Duration in days"};

    // should be passed the selected project
    public SuccessorTasksModel(Project project)
    {
        this.project = project;   // passes projects to class level
    }   // Constructor

    @Override
    public int getRowCount() {
        return project.getTasks().size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Task task = project.getTasks().get(rowIndex); // Get the task at the specified row

        switch (columnIndex) {
            case 0:
                return task.getDescription(); // Return the task's description for the first column
            case 1:
                return task.getDurationInDays(); // Return the task's duration for the second column
            default:
                throw new IllegalArgumentException("Invalid column index");
        }
    }
}
