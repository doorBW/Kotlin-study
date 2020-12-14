package ch4

import org.junit.Test



class Ch4test(){

    @Test
    fun test1(){
        // 1-1. 자바에서의 클래스나 함수의 기본 변경자는? open / final
        // 1-2. 코틀린에서 클래스나 함수의 기본 변경자는? open / final
        // 1-3. 코틀린에서 override한 클래스나 함수의 기본 변경자는? open / final
        // 1-4. 코틀린에서 추상클래스의 기본 변경자는? open / final
        // 1-5. 코틀린에서 인터페이스 기본 변경자는? open / final
    }

    @Test
    fun test2(){
        // 다음 클래스 선언을 최대한 축약시키시오.
        class Test constructor(_a: Int, name: String, country: String = "Korea"){
            val number: Int
            init{
                number = _a
            }
            val name: String
            val country: String
            init{
                this.name = name
                this.country = country
            }
        }
        //
    }

    @Test
    fun test3(){
        // 클래스와 인터페이스를 상속할 때 기반 클래스(인터페이스)를 명시하는 것에서 확인되는 차이는 무엇인가?
        // 그리고 그 차이가 발생되는 이유는?
    }

    interface CntTestInterface {
        val ss: String
    }
    @Test
    fun test4(){
        var firstCnt = 0
        var secondCnt = 0

        fun String.firstCntUp(): String {
            firstCnt += 1
            return "1"
        }
        fun String.secondCntUp():String {
            secondCnt += 1
            return "2"
        }

        class CntTestFirstClass(val s: String): CntTestInterface{
            override val ss: String
                get() = s.firstCntUp()
        }

        class CntTestSecondClass(val s: String): CntTestInterface{
            override val ss = s.secondCntUp()
        }

        val tc1 = CntTestFirstClass("tc1")
        val tc2 = CntTestSecondClass("tc2")
        println("firstCnt: $firstCnt , secondCnt: $secondCnt")
        tc1.ss
        tc1.ss
        tc2.ss
        tc2.ss
        println("firstCnt: $firstCnt , secondCnt: $secondCnt")
        CntTestFirstClass("tc1")
        CntTestSecondClass("tc2")
        println("firstCnt: $firstCnt , secondCnt: $secondCnt")
    }

    @Test
    fun test5(){ // 출력 순서 맞추기.
        val lazyVal by lazy  {
            println("lazy value init!")
            "lazy!"
        }
        println("start")
        println("call lazy: $lazyVal")
        println("end")
    }

    @Test
    fun test6(){
        class EqualsTest(val name:String, val number:Int){
            override fun equals(other: Any?): Boolean {
                if(other == null || other !is EqualsTest) return false
                return name==other.name && number==other.number
            }
        }

        val e1 = EqualsTest("철수",1)
        val e2 = EqualsTest("영희", 2)
        val e3 = EqualsTest("철수", 1)
        val e4 = e1

        println(e1 == e2)
        println(e1 == e3)
        println(e1 == e4)
        println(e1 === e2)
        println(e1 === e3)
        println(e1 === e4)

    }
}