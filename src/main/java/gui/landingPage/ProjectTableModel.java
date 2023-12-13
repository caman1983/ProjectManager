package gui.landingPage;

import entities.Project;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

// Class for table panel, to display projects
public class ProjectTableModel extends AbstractTableModel // Class
{
    // Class variables
    private List<Project> projects = new ArrayList<>();
    private final String[] columnNames = {"Name", "Deadline", "Budget"};  // string table of column names


    // Constructor, takes a list of project objects and passes to class level
    public ProjectTableModel(List<Project> projects)
    {
        this.projects = new ArrayList<>(projects);
    } // Constructor


    // Override abstract methods
    // Return row count, checks size of project list
    @Override
    public int getRowCount()
    {
        return projects.size();
    }

    // return column size, checks size of column names list
    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }

    // returns column name by passing index of desired column
    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }

    // get value of object in desired location
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Project project = projects.get(rowIndex);
        switch (columnIndex) {
            case 0: return project.getName();
            case 1: return project.getDeadline().toString(); // Assuming LocalDate
            case 2: return project.getBudget();
            default: throw new IllegalArgumentException("Column index out of bounds");
        }
    }

    //add project object to table
    public void addProject(Project project)
    {
        // add project object to list of project objects
        projects.add(project);

        // insert object into table -1 of project size, as project.size would be out of bounds
        fireTableRowsInserted(projects.size() - 1, projects.size() - 1);
    }

   //remove project object at specified index from table
    public void removeProject(int rowIndex)
    {
       projects.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
}
