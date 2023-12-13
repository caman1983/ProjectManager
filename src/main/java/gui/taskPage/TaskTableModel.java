package gui.taskPage;

import entities.Project;
import entities.Task;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TaskTableModel extends AbstractTableModel // Class
{
    private final List<Project> projects;
    private final String[] columnNames = {"Project:", "Description", "Duration (Days)", "Tasks"};

    public TaskTableModel(List<Project> projects) {
        this.projects = projects;
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
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Project project = projects.get(rowIndex);
        switch (columnIndex)
        {
            case 0: return project.getName();
            case 1: return "";  // Initially empty
            case 2: return "";  // Initially empty
            case 3: return "";  // Initially empty
            default: throw new IllegalArgumentException("Invalid column index");
        }
    }
}

