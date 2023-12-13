//import graph.TaskGraph
import javax.swing.SwingUtilities
import gui.landingPage.LandingFrame

// driver class
fun main(args: Array<String>)
{
//    //create object of project

//
//
//    //Create object of task
//    var firstTask = Task(1, "My First Task", 5)
//    var secondTask = Task(2, "My Second Task", 15)

//    firstProject.tasks.add(firstTask)
//    firstProject.tasks.add(secondTask)

    //println(firstProject.tasks)


//
//    val graph = TaskGraph(firstProject)
//    graph.convertMatrix()
//    graph.printMatrix()

    SwingUtilities.invokeLater {
        LandingFrame()
    }
}