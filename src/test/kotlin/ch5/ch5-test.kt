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
    }

    @Test
    fun test2() {
        val list = listOf(1,2,3,4)
        println(list.map{it} == list)
        println(list.map{it} === list)
        /** 2. 동등성 확인
         * true
         * false
         * map함수를 이용하면 새로운 컬렉션을 만들어 반환한다.
         */
    }

    @Test
    fun test3(){
        val people = listOf(Person("Alice",39), Person("bob",21))
        val underThirty = {p:Person -> p.age < 30}
        println(people.filter(underThirty).size)
        println(people.count(underThirty))
        /**
         * 3. 효율성
         * 조건을 만족하는 원소의 개수를 구하는데에 있어서
         * filter().size 와 count() 으로 같은 값을 얻을 수 있지만,
         * 어떤 것이 더 적합한가?
         */
    }
}