package ch7

import org.junit.Test





class Ch7Test{
    @Test
    fun test1(){
        /**
         * 1. 출력결과 예상하기
         * true
         * false
         * Point1(x=2, y=2)
         * Point1(x=1, y=1)
         */
        // Point1
        data class Point1(var x: Int, var y: Int){
            operator fun plus(o: Point1): Point1{
                return Point1(x + o.x, y + o.y)
            }
        }

        var p1 = Point1(1,1)
        var p2 = Point1(1,1)
        var p3 = p1
        println(p1 === p3)
        p1 += p2
        println(p1 === p3)
        println(p1)
        println(p3)
    }

    @Test
    fun test2(){
        /**
         * 2. 출력결과 예상하기
         * true
         * true
         * Point2(x=2, y=2)
         * Point2(x=2, y=2)
         */
        // Point2
        data class Point2(var x: Int, var y: Int){
            operator fun plus(o: Point2): Point2{
                x += o.x
                y += o.y
                return this
            }
        }

        var p1 = Point2(1,1)
        var p2 = Point2(1,1)
        var p3 = p1
        println(p1 === p3)
        p1 += p2
        println(p1 === p3)
        println(p1)
        println(p3)
    }
}