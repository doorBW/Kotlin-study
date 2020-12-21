package ch6

fun showProgress(progress: Int){
    val percent = progress.coerceIn(0, 100)
    println("We're ${percent}% done!")
}


fun main(){
    showProgress(146)
    val s1: String? = ""
    val s2: String? = null
    if (s1 != null) {
        println(s1.javaClass)
    }

    val x =1
    val list = listOf(1L, 2L, 3L)
    println(x in list)
}