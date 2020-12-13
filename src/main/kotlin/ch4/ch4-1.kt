package ch4

/**
 * 코틀린에서의 인터페이스
 * 추상 메소드 뿐 아니라 구현이 있는 메소드도 정의가 가능하다.
 * 다만, 아무런 상태(필드)도 들어갈 수 없다.
 */
interface Clickable {
    fun click() // 일반 추상 메소드
    fun showOff() = println("I'm clickable!") // 디폴트 구현이 있는 메소드
}

/**
 *  콜론(:)을 이용해서 상속한다.
 *  자바와 마찬가지로,
 *  인터페이스는 개수 제한 없이 구현 가능하지만,
 *  클래스는 오직 하나만 확장이 가능하다.
 */
class Button : Clickable {
    /**
     * 자바에서의 @Override 어노테이션과 비슷한 역할을 하는 override 변경자.
     * 프로퍼티나 메소드를 오버라이드 한다는 표시이며, 자바와 달리 꼭 명시해주어야 한다.
     */
    override fun click() = println("I was clicked")
}

interface Focusable {
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus.")
    fun showOff() = println("I'm focusable!") // Clickable 인터페이스에서 구현된 메소드와 동일한 시그니처의 함수.
}

class Button2 : Clickable, Focusable {
    override fun click() = println("I was clicked")
    override fun showOff() {
        println("1")
        super<Clickable>.showOff()
        println("2")
        super<Focusable>.showOff()
        println("3")
    }
}

open class RichButton : Clickable {
    fun disable() {}
    open fun animate() {}
    final override fun click() {} // override한 메소드는 기본적으로 열려있다. 따라서 상속을 막기위해 final 을 명시해줘야 한다.
}

class Animated{
    fun animate(){

    }
}

interface InterfaceAnimated{
    fun animate()
    open fun stopAnimating(){

    }
    fun animateTwice(){

    }
}

class InheritInterfaceClass: InterfaceAnimated{
    override fun animate() {
        TODO("Not yet implemented")
    }

}

abstract class AbstractAnimated {
    abstract fun animate()
    open fun stopAnimating(){

    }
    fun animateTwice(){

    }
}

class InheritAbstractClass: AbstractAnimated() {
    override fun animate() {
        TODO("Not yet implemented")
    }

}

class InternalMemberCheckClass(){
    val valMem = 1
    protected val publicValMem = 2
    internal val internalValMem = 3
}


class Outer{
    inner class Inner{
        fun getOuterReference(): Outer = this@Outer
    }
}

fun main() {
    Button().click()
    Button2().showOff()
}