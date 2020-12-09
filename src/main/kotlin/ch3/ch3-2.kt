package ch3

// 3.2.3
const val UNIX_LINE_SEPARATOR = "\n"
const val ONE = 1

// 3.2.1
fun <T> joinToString(
    collection: Collection<T>,
    separator: String,
    prefix: String,
    postfix: String
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

// 3.2.2
@JvmOverloads
fun <T> joinToString2 (
    collection: Collection<T>,
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
):String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun main(args: Array<String>) {
    // 3.2.1
    val list = listOf(1, 2, 3)
    println(list)
    // [1, 2, 3]
    println(joinToString(list, "; ", "(", ")"))
    // (1; 2; 3)
    println(joinToString(list, " ", " ", "."))
    // 1 2 3.
    println(joinToString(list, separator = " ", prefix = " ", postfix = "."))
    // 1 2 3.

    // 3.2.2
    println(joinToString2(list))
    // 1, 2, 3
}
