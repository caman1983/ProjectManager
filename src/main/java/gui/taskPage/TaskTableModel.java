package gui.taskPage;

import entities.Project;
import entities.Task;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TaskTableModel extends AbstractTableModel
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
        switch (columnIndex) {
            case 0: return project.getName();
            default: throw new IllegalArgumentException("Invalid column index");
        }
    }

//    private Task getTaskByRpowIndex(int rowIndex) {
//        int taskCount = 0;
//        for (Project project : projects) {  // Iterate over each project
//            for (Task task : project.getTasks()) {  // Iterate over tasks of each project
//                if (taskCount == rowIndex) {
//                    return task;
//                }
//                taskCount++;
//            }
//        }
//        throw new IllegalArgumentException("Invalid row index");
//    }




}

