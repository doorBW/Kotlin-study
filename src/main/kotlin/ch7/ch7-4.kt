package ch7

fun main(){
    val p = Point(10,20)
    val (x,y) = p
    println(x)
    println(y)

    val p2 = Point(y=100, x=200)
    val (x2, y2) = p2
    println(x2)
    println(y2)
}