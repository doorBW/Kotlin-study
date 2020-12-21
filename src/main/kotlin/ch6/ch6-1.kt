package ch6

//fun strLenSafe(s: String?) = s.length()
fun strLenSafe(s: String?): Int = if (s != null) s.length else 0

class Person(val firstName: String, val lastName: String) {
    override fun equals(o: Any?): Boolean {
        val otherPerson = o as? Person ?: return false
        return otherPerson.firstName == firstName && otherPerson.lastName == lastName
    }

    override fun hashCode(): Int =
        firstName.hashCode() * 37 + lastName.hashCode()
}

fun sendEmailTo(email:String){
    println("Sending email to $email")
}

fun main() {
    var val1: String? = ""
    var val2: String = ""
    println(val2 == val2)
    println(val2 === val2)
    val1 = null
    println(val1 === val2)

    val p1 = Person("Dmitry", "Jemerov")
    val p2 = Person("Dmitry", "Jemerov")
    println(p1 == p2)
    println(p1.equals(42))

    var email: String? = "yole@example.com"
    email?.let { sendEmailTo(it) }
    email = null
    email?.let { sendEmailTo(it) }
}