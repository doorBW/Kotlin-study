package ch3

// 3.3
fun String.lastChar(): Char = this.get(this.length - 1)

// 3.3.3
fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

// 3.3.5
val String.lastChar: Char
    get() = get(length - 1)

fun main(args: Array<String>) {
    // 3.3
    println("Kotlin".lastChar())
    // n

    // 3.3.3
    val list = listOf(1, 2, 3)
    println(list.joinToString())
    //1, 2, 3

    // 3.3.5
    println("Kotlin".lastChar)
    // n
}