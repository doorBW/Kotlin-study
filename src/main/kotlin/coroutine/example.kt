package coroutine

import kotlinx.coroutines.*
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit

fun now() = ZonedDateTime.now().toLocalTime().truncatedTo(ChronoUnit.MILLIS)

fun log(msg:String) = println("${now()}:${Thread.currentThread()}: ${msg}")

fun launchInGlobalScope(){
    GlobalScope.launch {
        log("coroutine started.")
    }
}

fun runBlockingExample(){
    runBlocking {
        launch {
            log("GlobalScope.launch started.")
        }
    }
}

fun yieldExample(){
    runBlocking {
        launch{
            log("1")
            yield()
            log("3")
            yield()
            log("5")
        }

        log("after first launch")
        Thread.sleep(1000L)
        launch{
            log("2")
            delay(1000L)
            log("4")
            delay(1000L)
            log("6")
        }
        log("after second launch")
    }
    log("after runBlocking")
}

fun sumAll(){
    runBlocking{
        val d1 = async { log("d1 return"); delay(1000L); 1}
        log("after async(d1)")
        val d2 = async { log("d2 return"); delay(2000L); 2}
        log("after async(d2)")
        val d3 = async { log("d3 return"); delay(3000L); 3}
        log("after async(d3)")
        val d4 = async { log("d4 return"); delay(10000L); 4}
        log("after async(d4)")

        log("1+2+3 = ${d1.await() + d2.await() + d3.await()}")
        log("after await all & add")
    }
}

fun main(){
//    log("main() started.")
//    launchInGlobalScope()
//    log("launchInGlobalScope() executed.")
//    /**
//     * sleep이 없다면, main이 바로 끝나고, 메인 스레드가 종료되면서 프로그램 전체가 끝나버린다.
//     * 이를 방지하려면 비동기적으로 launch를 실행시키거나, launch가 모두 실행될때까지 대기해야 한다.
//     * 코루틴의 실행이 끝날때까지 현재 스레드를 블록시키는 함수로 runBlocking()이 있다.
//     */
//    Thread.sleep(5000L)
//    log("main() terminated.")

//    log("main() started.")
//    runBlockingExample()
//    log("launchInGlobalScope() executed.")
////    Thread.sleep(5000L)
//    log("main() terminated.")

//    log("main() started.")
//    yieldExample()
//    log("yieldExample() executed.")
////    Thread.sleep(5000L)
//    log("main() terminated.")

    log("main() started.")
    sumAll()
    log("sumAll() executed.")
    log("main() terminated.")
}