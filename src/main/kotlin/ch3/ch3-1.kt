package ch3

fun main(args: Array<String>){
    // 3.1
    val set = hashSetOf(1,7,53)
    println(set)
    // [1, 53, 7]
    println(set.javaClass)
    // class java.util.HashSet
    val list = arrayListOf(1,7,53)
    println(list)
    // [1, 7, 53]
    println(list.javaClass)
    // class java.util.ArrayList
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
    println(map)
    // {1=one, 53=fifty-three, 7=seven}
    println(map.javaClass)
    // class java.util.HashMap

    val strings = listOf("first", "second", "fourteenth")
    println(strings.last())
    // fourteenth
    println(strings.size)
    // 3
    val numbers = setOf(1,14,2)
    println(numbers.max())
    // 14
    println(numbers.average())
    // 5.666666666666667

}