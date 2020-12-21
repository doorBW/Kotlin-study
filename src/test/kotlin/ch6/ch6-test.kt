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

    }
}