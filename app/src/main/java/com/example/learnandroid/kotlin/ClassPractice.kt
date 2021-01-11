package com.example.learnkotlin.kotlin

open class Human(val name : String = "Anonymous"){
    // 주 생성자의 일부
    init {
        println("New human has been born!!")
    }

    // 부 생성자
    constructor(name : String, age : Int) : this(name){
        println("my name is ${name}, ${age} years old")
    }

    fun eatingCake(){
        println("This is so ")
    }

    open fun singASong(){
        println("lalala")
    }
}

class Korean : Human() {

    override fun singASong(){
        super.singASong()
        println("라라랄")
        println("my name is ${this.name}")
    }
}

fun main(){
//    val human = Human("minuk")
//    val stranger = Human()
//
//    human.eatingCake()

//    val mom = Human("Kuri", 52)

//    println("this human's name is ${mom.name}")

//    val korean = Korean("minuk")
//    korean.singASong()
}