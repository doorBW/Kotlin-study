package ch3

import java.lang.IllegalArgumentException

// 3.6
class User(val id: Int, val name: String, val address: String)

fun saveUser_duplicated(user: User){
    if (user.name.isEmpty()){
        throw IllegalArgumentException("Can't save user ${user.id}: empty Name")
    }
    if (user.address.isEmpty()){
        throw IllegalArgumentException("Can't save user ${user.id}: empty Address")
    }
}

fun saveUser_better(user: User){
    fun validate(user: User, value: String, fieldName: String){
        if(value.isEmpty()){
            throw IllegalArgumentException("Can't save user ${user.id}: empty ${fieldName}")
        }
    }
    validate(user, user.name, "Name")
    validate(user, user.address, "Address")
}

fun saveUser(user: User){
    fun validate(value: String, fieldName: String){
        if(value.isEmpty()){
            throw IllegalArgumentException("Can't save user ${user.id}: empty ${fieldName}")
        }
    }
    validate(user.name, "Name")
    validate(user.address, "Address")
}

fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String){
        if(value.isEmpty()){
            throw IllegalArgumentException("Can't save user ${id}: empty ${fieldName}")
        }
    }
    validate(name, "Name")
    validate(address, "Address")
}

fun saveUser_expand(user: User){
    user.validateBeforeSave()
    // save
}

fun main(args: Array<String>) {

}