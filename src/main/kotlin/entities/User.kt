package entities

// class for user
data class User(
    val userName: String,
    val isAdmin: Boolean,
    private val password: String
) {
    fun isPasswordCorrect(inputPassword: String): Boolean
    {
        // Placeholder for password validation logic
        return password == inputPassword
    }
}