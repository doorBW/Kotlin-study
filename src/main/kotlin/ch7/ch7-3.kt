package ch7

import java.time.LocalDate

operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
    object : Iterator<LocalDate> {
        var current = start
        override fun hasNext(): Boolean {
            println("hasNext called!")
            println("start: $start")
            println("current: $current")
            println("endInclusive: $endInclusive")
            return current <= endInclusive
        }
        override fun next(): LocalDate {
            println("next called!")
            return current.apply { current = plusDays(1) }
        }
    }

fun main() {
    val now = LocalDate.now()
    val vacation = now..now.plusDays(10)
    println(vacation.javaClass)
    println(now.plusWeeks(1) in vacation)

    val newYear = LocalDate.ofYearDay(2017, 1)
    val daysOff = newYear.minusDays(5)..newYear
    for (dayoff in daysOff) {
        println(dayoff)
        println()
    }
}