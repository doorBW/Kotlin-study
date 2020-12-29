package ch6

import java.io.BufferedReader
import java.io.StringReader
import java.lang.NumberFormatException


fun addValidNumbers(numbers: List<Int?>){
    var sumOfValidNumbers = 0
    var invalidNumbers = 0
    for(number in numbers){
        if(number != null){
            sumOfValidNumbers += number
        }else{
            invalidNumbers++
        }
    }
    println("Sum Of valid numbers: $sumOfValidNumbers")
    println("Invalid numbers: $invalidNumbers")
}

fun readNumbers(reader: BufferedReader): List<Int?> {
    val result = ArrayList<Int?>()
    for(line in reader.lineSequence()){
//        try{
//            val number = line.toInt()
//            result.add(number)
//        }catch(e: NumberFormatException){
//            result.add(null)
//        }
        val number = line.toIntOrNull()
        result.add(number)
    }
    return result
}

fun main(){
    val reader = BufferedReader(StringReader("1\na\n2\n]]\n3"))
    val numbers = readNumbers(reader)
    addValidNumbers(numbers)

    val letters = Array(26){println(it);('a'+it).toString()}
    println(letters.joinToString(""))
}