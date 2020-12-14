package ch4

class Client(val name: String, val postalCode: Int){
    override fun equals(other: Any?): Boolean{
        if(other == null || other !is Client){
            return false
        }
        return name == other.name && postalCode == other.postalCode
    }

    override fun toString() = "Client(name=$name, postalCode=$postalCode)"
}

data class DataClient(val name: String, val postalCode: Int)

fun main(){
    val dc1 = DataClient("a",1)
    val dc2 = DataClient("a",1)
    println("test")
    println(dc1 == dc2)
    println(dc1)
}