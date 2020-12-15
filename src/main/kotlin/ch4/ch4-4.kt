package ch4

data class Person(val name: String) {
    object NameComparator : Comparator<Person> {
        override fun compare(o1: Person, o2: Person): Int =
            o1.name.compareTo(o2.name)
    }
}

fun main(){
    val p1 = Person("a")
    val p2 = Person("b")
    val persons = listOf(p1,p2)
    println(Person.NameComparator.compare(p1,p2))
    println(persons.sortedWith(Person.NameComparator))
}