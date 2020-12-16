package ch5



fun main(){
    val list = listOf(1,2,3,4)
    println(list.map{it} == list)
    println(list.map{it} === list)

    val people = listOf(Person("Alice",29), Person("Bob",31))
    println(people.maxBy ( Person::age)!!.age)

    println(!list.all{it == 3})
    println(list.any{it != 3})

    val strings = listOf("abc","def")
    println(strings.map{it.toList()})
    println(strings.flatMap{it.toList()})
    println(strings.map{it.toList()}.flatten())
}