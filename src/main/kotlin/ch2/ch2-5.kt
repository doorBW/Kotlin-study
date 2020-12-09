package ch2

import java.io.BufferedReader
import java.io.StringReader

// 2.5.2
fun readNumber1 (reader: BufferedReader){
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException){
        return
    }
    println(number)
}

fun readNumber2 (reader: BufferedReader){
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException){
        null
    }
    println(number)
}

fun main(args: Array<String>) {
    var number = 10
    val percentage =
        if (number in 0..100)
            number
        else
            throw IllegalArgumentException("A percentage value must be between 0 and 100: ${number}")

    // 2.5.2
    val reader = BufferedReader(StringReader("not a number"))
    readNumber1(reader)
    readNumber2(reader)
}