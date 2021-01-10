package ch7

import org.junit.Test
import java.math.BigDecimal


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

    @Test
    fun test3(){
        /**
         * 3. 출력 확인하기
         * 10
         * 20
         * 200
         * 100
         */
        val p = Point(10,20)
        val (x,y) = p
        println(x)
        println(y)

        val p2 = Point(y=100, x=200)
        val (x2, y2) = p2
        println(x2)
        println(y2)
        var a = 1;
        println(++a);
        
    }
}