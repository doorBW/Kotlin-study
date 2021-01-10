package ch7

data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }

    operator fun unaryPlus(): Point{
        return Point(x+1, y+1)
    }
}

fun main() {
    operator fun Point.times(o: Point): Point{
        return Point(x + o.x, y + o.y)
    }
    var p1 = Point(10,20)
    var p2 = Point(30,40)
    var p3 = p1
    println(p1 + p2)
    println(+p1)
    println(p1 + p2)

    println(p1 === p1)
    println(p1 === p2)
    println(p1 === p3)
    p1 += p2
    println(p1 === p1)
    println(p1 === p2)
    println(p1 === p3)


}