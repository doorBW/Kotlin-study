package ch5

data class Person(val name: String, val age: Int)

fun findTheOldest(people: List<Person>) {
    var maxAge = 0
    var theOldest: Person? = null
    for (person in people) {
        if (person.age > maxAge) {
            maxAge = person.age
            theOldest = person
        }
    }
    println(theOldest)
}


fun main() {
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    findTheOldest(people)
    println(people.maxBy { it.age })

    val sum = { x: Int, y: Int -> x + y }
    println(sum(1, 2))
    run { println(42) }

    fun salute() = println("Salute!")
    run(::salute)
}