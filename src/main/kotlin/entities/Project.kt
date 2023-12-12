package entities
import java.time.LocalDate

/*
Data class for Project - data tasks allows omission of boilerplate code such as setters and getters
name : project name
deadline : project deadline
budget : project budget
tasks : tasks of projects
*/
data class Project(
    var name: String,
    var deadline: LocalDate,
    var budget: Double,
    var tasks: MutableList<Task> = mutableListOf(),

)
