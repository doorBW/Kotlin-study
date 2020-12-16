package ch5

import org.junit.Test

class Ch5Test {

    fun sum(a: Int, b: Int): Int {
        println("outer function called!")
        return a + b
    }
    @Test
    fun test1() {
        println(sum(1, 2))
        val sum = { x: Int, y: Int ->
            println("lambda called!")
            x + y
        }
        println(sum(1, 2))

        fun sum(a: Int, b: Int): Int {
            println("inner function called!")
            return a + b
        }
        println(sum(1, 2))
        println()

        /** 1. 출력 순서
         * outer function called!
         * 3
         * lambda called!
         * 3
         * inner function called!
         * 3
         */

        /**
         *
         */
    }
}