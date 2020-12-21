package ch6

import org.junit.Test

class Ch6Test{
    @Test
    fun test1(){
        fun strLenSafe(s: String?): Int = if (s != null) s.length else 0
        /** 1. 위 함수의 if의 노란색 부분을 최대한 축약하면?
         * ~ = s?.length ?: 0
         */
    }

    @Test
    fun test2(){
        var numberList = listOf(1L,2L,3L,4L,5L)
        val n1 = numberList.random()
        val n2 = numberList.random()
        numberList.plus(n1*n2)
        println(4 in numberList)
        /**
         * 2. println의 결과는?
         * 컴파일되지 않는다. 같은 타입이 아니기 때문에.
         */
    }
}