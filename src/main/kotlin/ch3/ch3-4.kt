package ch3

fun main(args: Array<String>) {
    // 3.4.2
    val list = listOf("args: ", *args)
    println(list)
}