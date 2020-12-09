package ch2

// 2.3 enum, when
// 2.3.1 enum class
enum class Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

enum class Color2(
    val r: Int, val g: Int, val b: Int
) {
    RED(255, 0, 0), ORANGE(255, 165, 0),
    YELLOW(255, 255, 0), GREEN(0, 255, 0), BLUE(0, 0, 255),
    INDIGO(75, 0, 130), VIOLET(238, 130, 238); // need semicolon

    fun rgb() = (r * 256 + g) * 256 + b
}

// 2.3.2 when
fun getMnemonic(color: Color2) =
    when (color) {
        Color2.RED -> "Richard"
        Color2.ORANGE -> "Of"
        Color2.YELLOW -> "York"
        Color2.GREEN -> "Gave"
        Color2.BLUE -> "Battle"
        Color2.INDIGO -> "In"
        Color2.VIOLET -> "Vain"
    }

fun getWarmth(color: Color2) = when (color) {
    Color2.RED, Color2.ORANGE, Color2.YELLOW -> "warm"
    Color2.GREEN -> "neutral"
    Color2.BLUE, Color2.INDIGO, Color2.VIOLET -> "cold"
}

fun mix(c1: Color2, c2: Color2) =
    when (setOf(c1, c2)) {
        setOf(
            Color2.RED,
            Color2.YELLOW
        ) -> Color2.ORANGE
        setOf(
            Color2.YELLOW,
            Color2.BLUE
        ) -> Color2.GREEN
        setOf(
            Color2.BLUE,
            Color2.VIOLET
        ) -> Color2.INDIGO
        else -> throw Exception("Dirty ch2.Color")
    }

// 2.3.5
interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int {
    if (e is Num) { // smart casting
        val n = e as Num
        return n.value
    }
    if (e is Sum) { // smart casting
        return eval(e.right) + eval(e.left)
    }
    throw IllegalArgumentException("Unknown expression")
}

// 2.3.6
fun eval2(e: Expr): Int =
    when (e) {
        is Num -> e.value
        is Sum -> eval(e.left) + eval(e.right)
        else -> throw IllegalArgumentException("Unknown expression")
    }
// 2.3.7
fun evalWithLogging(e: Expr): Int =
    when (e) {
        is Num -> {
            println("num: ${e.value}")
            e.value
        }
        is Sum -> {
            val left = evalWithLogging(e.left)
            val right = evalWithLogging(e.right)
            println("sum: ${left} + ${right}")
            left + right
        }
        else -> throw IllegalArgumentException("Unknown expression")
    }

fun main(args: Array<String>) {
    // 2.3.1
    println(Color2.BLUE.rgb())

    // 2.3.2
    println(getMnemonic(Color2.BLUE))

    // 2.3.3
    println(mix(Color2.BLUE, Color2.YELLOW))

    // 2.3.5
    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))

    // 2.3.6
    println(eval2(Sum(Sum(Num(1), Num(2)), Num(4))))

    // 2.3.7
    println(evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(4))))
}
