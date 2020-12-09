package ch3

fun main(args: Array<String>) {
    // 3.5.1
    println("1.2-3^4.5-6^7")
    println("1.2-3^4.5-6^7".split('.'))
    println("1.2-3^4.5-6^7".split('.','-'))
    println("1.2-3^4.5-6^7".split('.','^'))
    println("1.2-3^4.5-6^7".split('.','-','^'))

    // 3.5.2
    println("1.2.3.4.5.6.7.8".substringBeforeLast('.'))
    println("1.2.3.4.5.6.7.8".substringAfterLast('.'))
}