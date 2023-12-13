package graph

import entities.Project
import entities.Task
import java.beans.PropertyEditor
import java.time.LocalDate

//class TaskGraph(private var project: Project)
//{
//    // Class variables
//    private val numberOfNodes = project.tasks.count() + 1
//    private var adjacencyMatrix: Array<IntArray> = Array(numberOfNodes) { IntArray(numberOfNodes) { 0 } }
//
//    // Initialisation code
//    init
//    {
//
//       //project.tasks.add(Task(2, "My first Task", 15))
//       //project.tasks.add(Task(3, "My second Task", 15))
//    }
//
//    fun convertMatrix(): Array<IntArray>
//    {
//        // Connect the project node (0th node) to all top-level tasks
//        project.tasks.forEachIndexed { index, task ->
//            if (task.successorTasks.isEmpty()) {
//                adjacencyMatrix[0][index + 1] = 1  // +1 because 0th is the project node
//            }
//        }
//
//        // Set relationships for tasks and their successors
//        for (i in 1 until numberOfNodes) {
//            project.tasks[i - 1].successorTasks.forEach { successor ->
//                val j = project.tasks.indexOf(successor) + 1
//                if (j != -1) {
//                    adjacencyMatrix[i][j] = 1
//                }
//            }
//        }
//        return adjacencyMatrix
//    }
//
//
//    fun printMatrix()
//    {
//        val adjMatrix = convertMatrix()
//        println("Adjacency Matrix for Project: ${project.name}")
//        adjMatrix.forEach { row ->
//            println(row.joinToString(" "))
//    }
//

//}
//
//}