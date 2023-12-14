package entities

import java.time.Duration

/*
Data class for Task
id : unique identifier
description : description of task
duration : estimated duration of task
successorTask : child or subtasks
*/
data class Task(
    var description: String,
    var durationInDays: Int,
)
{
    var parentProject: Project? = null // pointer to parent object
}

