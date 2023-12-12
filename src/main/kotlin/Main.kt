import entities.Project
import entities.Task
import graph.TaskGraph
import java.time.LocalDate
import javax.swing.SwingUtilities
import gui.MainFrame

// driver class
fun main(args: Array<String>)
{
    //create object of project
    var firstProject = Project("FirstProject", LocalDate.parse("2001-12-23"), 22.0)


    //Create object of task
    var firstTask = Task(1, "My First Task", 5)
    var secondTask = Task(2, "My Second Task", 15)

    firstProject.tasks.add(firstTask)
    firstProject.tasks.add(secondTask)

    //println(firstProject.tasks)



    val graph = TaskGraph(firstProject)
    graph.convertMatrix()
    graph.printMatrix()

    SwingUtilities.invokeLater {
        MainFrame()
    }
}