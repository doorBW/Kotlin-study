package ch3

import groovy.util.GroovyTestCase.assertEquals
import org.junit.Test

class Ch3Test {

    @Test
    fun test3() {
        // make 'what' function!
        assertEquals(3.what(3), 27)
    }

    @Test
    fun test4() {
        /*
            java에서는 상속의 재 정의를 방지하기 위해 final을 사용.
            kotlin에서는 반대로 상속의 재 정의를 허용하기 위해서 open을 사용.
         */
    }

    @Test
    fun test5() {
        val list = listOf(1, 2, 3, 4, 5)
        println(list.filter { it > 2 }.map { it * 2 })
    }

    @Test
    fun test6() {
        open class View() {}
        class Button() : View() {}

        fun View.show() = println("View")
        fun Button.show() = println("Button")

        val view: View = Button()
        view.show() // ??
        (view as Button).show() // ??
    }

    @Test
    fun test7() {
        class Something(){
            fun method(){
                println("member method!")
            }
        }
        fun Something.method() = println("extenstion method!")

        val s = Something()
        s.method();
    }


}