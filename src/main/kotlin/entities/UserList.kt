package entities


// Hard coded for now
data class UserList
    (val userList: List<User> = listOf(
    User("Cameron", true, "password"),
    User("Ivo", false, "password")
    ))
