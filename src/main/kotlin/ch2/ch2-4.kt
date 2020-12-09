package ch2

import java.util.*

// 2.4.2
fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "${i} "
}

// 2.4.4
fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9' // can not use 'not in'
fun recognize(c: Char) = when(c){
    in '0'..'9' -> "It's a digit!"
    in 'a'..'z', in 'A'..'Z'-> "It's a letter!"
    else -> "I don't know."
}

fun main(args: Array<String>) {
    // 2.4.2
    val oneToTen = 1..10
    for (i in 0..5) {
        println("${i}, ${oneToTen.javaClass }")
    }
    for (i in 1..100) print(fizzBuzz(i))
    println()
    for (i in 100 downTo 1 step 2) print(fizzBuzz(i))
    println()
    for (i in 100..1) print(fizzBuzz(i)) // 100..1 -> empty list
    println()
    val size = oneToTen.count()
    for (i in 0..size) print(i)
    println()
    for (i in 0 until size) print(i) // list 0..size-1
    println()

    // 2.4.3
    val binaryReps = TreeMap<Char, String>()
    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }
    for((letter, binary) in binaryReps){
        println("${letter} = ${binary}")
    }
    val list = arrayListOf("10","11", "1001")
    for((index, element) in list.withIndex()){
        println("${index}: ${element}")
    }

    // 2.4.4
    println(isLetter('q'))
    println(isNotDigit('x'))
    println(recognize('8'))
    println("Kotlin" in "Java".."Scala")
    println("Kotlin" in "Zava".."Scala") // 문자열 제일 처음 요소로 대소비교.


}