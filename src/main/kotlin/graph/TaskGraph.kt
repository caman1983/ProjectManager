package graph

import entities.Project
import entities.Task
import java.beans.PropertyEditor
import java.time.LocalDate

class TaskGraph(private val project: Project) {

    fun createMatrix(): Array<Array<Boolean>> {
        val taskCount = project.tasks.size
        val matrix = Array(taskCount) { Array(taskCount) { false } }

        for (i in 0 until taskCount - 1) {
            // Set dependency from task i to task i+1
            matrix[i][i + 1] = true
        }

        return matrix
    }
}