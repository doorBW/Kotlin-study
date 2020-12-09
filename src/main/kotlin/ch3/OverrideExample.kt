package ch3

abstract class AbstractBase{
    abstract fun parentFunction()
    final fun notOverrideFunction(){}
}

open class AbstractOverrideExample() : AbstractBase(){
    override fun parentFunction() {

    }

//    override fun notOverrideFunction() { // error
//
//    }

}


class TwiceOverrideExample(): AbstractOverrideExample() {

}

