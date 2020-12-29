package ch6

import org.junit.Test
import java.io.BufferedReader

private val NUMBER = 4

class Ch6Test {
    @Test
    fun test1() {
        fun strLenSafe(s: String?): Int = if (s != null) s.length else 0
        /** 1. 위 함수의 if의 노란색 부분을 최대한 축약하면?
         * ~ = s?.length ?: 0
         */
    }

    @Test
    fun test2() {
        var numberList = listOf(1L, 2L, 3L, 4L, 5L)
        val n1 = numberList.random()
        val n2 = numberList.random()
        numberList.plus(n1 * n2)
//        val x = 4
//        println(x in numberList)
        /**
         * 2. println의 결과는?
         * 컴파일되지 않는다. 같은 타입이 아니기 때문에.
         */
    }

    @Test
    fun test3() {
        var numberList = listOf(1L, 2L, 3L, 4L, 5L)
        var numberList2 = listOf(1, 2, 3, 4, 5)

        println(4 in numberList)
        println(4 in numberList2)

        /**
         * 3. println의 결과는?
         * true
         * true
         */
    }

    @Test
    fun test4() {
        fun readNumbers(reader: BufferedReader): List<Int?> {
            val result = ArrayList<Int?>()
            for (line in reader.lineSequence()) {
                try {
                    val number = line.toInt()
                    result.add(number)
                } catch (e: NumberFormatException) {
                    result.add(null)
                }
            }
            return result
        }
        /**
         * 4. 위의 readNumbers 함수에서 try{}catch{} 구문을 삭제하여 간단히 만들면?
         *
         * val number = line.toIntOrNull()
         * result.add(number)
         */
    }

    @Test
    fun test5() {
        fun getSomeStr(): String?{
            return null
        }

        fun printStrInfo(any: Any?) {
            val s = any as? String ?: ""

            /* 1 */
            val allCaps = if (s != null) s.toUpperCase() else null
            println("Input str to allCaps: $allCaps")
        }

        val s = getSomeStr()

        /* 2 */
        printStrInfo(if (s != null) s else "")

        val otherS = getSomeStr()
        /* 3 */
        if(otherS != null){
            printStrInfo(otherS)
        }

        /** 정답
         * 1. s?.toUpperCase()
         * 2. s ?: ""
         * 3. otherS?.let{printStrInfo(it)}
         */
    }

    @Test
    fun other(){
        val strings = listOf("a", "b", "c", "d")
        println("%s%s%s%s".format(*strings.toTypedArray()))
    }
}

class SimpleTest {
    data class Address(var zipCode: Int, var street: String)
    data class Person(
        var name: String,
        var nickname: String? = null,
        var age: Int,
        var money: Int? = null,
        var address: Address,
        var cars: MutableList<String>,
        var immuCars: List<String>

    )
    // nullable type은 refrence type이 될까?
    @Test
    fun test1() {
        val p1 =
            Person(
                name = "donghwan",
                age = 38,
                money = 0,
                address = Address(16225, "대학3로"),
                cars = mutableListOf("GV80"),
                immuCars = arrayListOf("a","b")
            )
        println(p1.nickname?.javaClass)
        println("p1 nickname: ${p1.nickname.hashCode()}")
        println("p1 money: ${p1.money.hashCode()}")
        println("p1 address: ${p1.address.hashCode()}")
        p1.nickname = "aaa"
        println(p1.nickname?.javaClass)
        println("p1 nickname: ${p1.nickname.hashCode()}")
        println("p1 address: ${p1.address.hashCode()}")
        println("make p2 of p1 copy")
        val p2 = p1.copy()
        p2.nickname = "rich person"
        p2.money = 999999999
        // p2.address = Address(123, "")
        p2.address.street = "분당내곡로"
        p2.address.zipCode = 13442
        p2.cars.add("911")
        println("p1 nickname: ${p1.nickname.hashCode()}")
        println(p1.nickname?.javaClass)
        println("p2 nickname: ${p2.nickname.hashCode()}")
        println("p1 money: ${p1.money.hashCode()}")
        println("p2 money: ${p2.money.hashCode()}")
        println("p1 address: ${p1.address.hashCode()}")
        println("p2 address: ${p2.address.hashCode()}")
        println("p1: $p1")
        println("p2: $p2")
        println()
        hashCode()
    }
    data class Foo<T>(var v: T)
    // generic은?
    @Test
    fun test2() {
        val f1 = Foo(10)
        val f2 = f1.copy()
        f2.v = 99
        println("f1: $f1")
        println("f2: $f2")
    }
}