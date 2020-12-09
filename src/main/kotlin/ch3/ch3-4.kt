package ch3

fun main(args: Array<String>) {
    // 3.4.2
    val list = listOf("args: ", *args)
    println(list)

    // 3.4.3
    println(1.to("one"))
    val a = (1 to "one")
    val b = ("one" to 1)
    println(a)
    println(b)
    println(a.equals(b))
}