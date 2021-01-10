package ch7

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport

open class PropertryChangeAware {
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }
}

class Personn(
    val name: String, age: Int, salary: Int
) : PropertryChangeAware() {
    var age: Int = age
        set(newValue) {
            val oldValue = field
            field = newValue
            changeSupport.firePropertyChange("age", oldValue, newValue)
        }

    var salary: Int = salary
        set(newValue) {
            val oldValue = field
            field = newValue
            changeSupport.firePropertyChange("salary", oldValue, newValue)
        }
}

fun main() {
    val p = Personn("Dmitry", 34, 200)
    p.addPropertyChangeListener(PropertyChangeListener { event ->
        println(
            "Property ${event.propertyName} changed" +
                    "from ${event.oldValue} to ${event.newValue}"
        )
    })
    p.age = 35
    p.salary = 2100
}