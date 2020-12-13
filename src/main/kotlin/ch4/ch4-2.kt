package ch4

// class User(val nickname: String) // 주 생성자. 아래의 코드와 동일한 의미를 갖는다.
class User1 constructor(_nickname: String) {
    val nickname: String

    init {
        nickname = _nickname
    }
}

// nickname 프로퍼티를 초기화하는 코드(init내용)을
// nickname 프로퍼티 선언에 포함시킬 수 있어서 초기화 코드를 초기화 블록에 넣을 필요가 없다.
// 또 주 생성자 앞에 별다른 애노테이션이나 가시성 변경자가 없다면 constructor를 생략해도 된다.
class User2(_nickname: String) {
    val nickname = _nickname
}

class User3(val nickname: String)
// User1 -> User2 -> User3 순으로 축약되는 코드가 가능하다.

interface User {
    val nickname: String
}

class PrivateUser(override val nickname: String) : User

class SubscribingUser(val email: String) : User {
    override val nickname: String
        get() = email.substringBefore('@')
}

//class FacebookUser(val accountId: String): User{
//    override val nickname = getFacebookName(accountId) // getFacebookName 함수가 없어서 주석처리.
//}

var firstCnt = 0
var secondCnt = 0

interface CntTestInterface {
    val name: String
}

fun String.firstCntUp(): String {
    firstCnt += 1
    return "1"
}

fun String.secondCntUp(): String {
    secondCnt += 1
    return "2"
}

class CntTestFirstClass(val email: String) : CntTestInterface {
    override val name: String
        get() = email.firstCntUp()
}

class CntTestSecondClass(val email: String) : CntTestInterface {
    override val name = email.secondCntUp()
}

class UserAnother(val name: String) {
    var address: String = "unspecified"
        set(value: String) {
            println(
                """
            Address was changed for $name:
            "$field" -> "$value".
            """.trimIndent()
            )
            field = value
        }
}

fun main() {
    println(PrivateUser("test@kotlin.com").nickname)
    println(SubscribingUser("test@kotlin.com").nickname)
    println()
    CntTestFirstClass("test1")
    CntTestSecondClass("test2")
    println("1: $firstCnt, 2: $secondCnt")
    var tc1 = CntTestFirstClass("test1")
    var tc2 = CntTestSecondClass("test2")
    println("1: $firstCnt, 2: $secondCnt")
    tc1
    tc2
    println("1: $firstCnt, 2: $secondCnt")
    tc1.name
    tc2.name
    println("1: $firstCnt, 2: $secondCnt")
    tc1.name
    tc1.name
    tc1.name
    tc2.name
    tc2.name
    tc2.name
    println("1: $firstCnt, 2: $secondCnt")

    val user = UserAnother("Alice")
    user.address = "!@#!@#!@#!@#"
}
