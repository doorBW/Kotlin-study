package ch2

// 2.2 클래스와 프로퍼티
class Person(val name: String)
// 위와 같은 클래스(코드 없이 데이터만 저장하는 클래스)를 값 객체라고 부른다.

// 2.2.1 프로퍼티
class Person2(
    val name: String, // 읽기 전용 프로퍼티(val)
    var isMarried: Boolean // 쓸 수 있는 프로퍼티(var)
)

// 2.2.2 커스텀 접근자
class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() { // 프로퍼티 게터 선언
            return height == width
        }
}

fun main(args: Array<String>) {
    // 2.2.1
    val person = Person2("Bob", true)
    println(person.name)
    println(person.isMarried)

    // 2.2.2
    val rectangle = Rectangle(41, 43)
    println(rectangle.isSquare)
}