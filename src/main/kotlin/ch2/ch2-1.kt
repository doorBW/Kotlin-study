package ch2

fun main(args: Array<String>) {
    // 2.1 함수와 변수
    // 2.1.1 Hello, World!
    println("Hello, world!")
    /*
    - 함수 선언시 fun 키워드를 사용한다.
    - 파라미터 이름 뒤에 파라미터 타입, 변수 선언시에도 동일하다.
    - 자바와 달리 함수를 꼭 클래스에 넣어야하는건 아니다.
    - 배열도 일반적인 클래스와 동일하다.
    - 표준 자바 라이브러리 함수를 간결하게 사용할 수 있는 래퍼가 존재한다.(System.out.println -> println)
    - 세미콜론을 붙이지 않는다.
    */

    // 2.1.2 함수
    fun max(a: Int, b: Int): Int {
        return if (a > b) a else b
    }
    println(max(1, 2))
    /*
    - 코틀린에서 if는 식(expression)이다. 문(statement)이 아니다.
     */

    // 식이 본문인 함수.
    fun max2(a: Int, b: Int): Int = if (a > b) a else b

    /*
    - max함수와 같이 본문이 중괄호로 둘러쌓인 함수를 '블록이 본문인 함수'라고 하며,
    - max2함수와 같이 등호와 식으로 이루어진 함수를 '식이 본문인 함수'라고 한다.
    - 식이 본문인 함수의 경우 굳이 반환 타입을 명시하지 않아도 된다.(max2 -> max3)
     */
    fun max3(a: Int, b: Int) = if (a > b) a else b

    // 2.1.3 qustn
    val question = "삶, 우주, 그리고 모든 것에 대한 궁극적인 질문"
    val answer:Int = 42
    val answer2 = 42 // 선언과 초기화를 동시에 할때는 타입을 굳이 명시하지 않아도 된다.

    val answer3:Int
    answer3 = 42 // 선언과 초기화를 다르게 한다면 타입명시를 해야한다.

    // 변경 가능한 변수와 변경 불가능한 변수
    // val: 변경 불가능, 자바의 final 변수에 해당
    // var: 변경 가능, 자바의 일반 변수에 해당

    // val 참조 자체는 불변일지라도, 그 참조가 가리키는 객체의 내부 값은 변경될 수 있다.
    val languages = arrayListOf("Java")
    languages.add("Kotlin")

    // 변수의 타입은 고정된다.
    var answer4 = 42
    // answer4 = "no answer" // Error: type mismatch

    // 2.1.4 더 쉽게 문자열 형식 지정: 문자열 템플릿
    val name = if (args.size > 0) args[0] else "Kotlin"
    println("Hello, $name!") // $ 기호를 이용한다.
    /*
    - 문자열 $ 를 입력하고 싶으면, \$ 를 이용한다.
    - 복잡한 식 또한 중괄호를 이용하여 감싸면 된다.
     */
    println("Hello, ${if (args.size > 0) args[0] else "Kotlin"}!!")
}

