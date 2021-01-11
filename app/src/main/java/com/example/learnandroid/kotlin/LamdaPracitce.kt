package com.example.learnkotlin.kotlin

// 1. Lamda
// 람다식은 우리가 마치 value 처럼 다룰 수 있는 익명함수이다.
// 1) 메모드의 파라미터로 넘겨줄 수가 있다. fun maxBy(a : Int)
// 2) return 값으로 사용할 수가 있다.

// 람다의 기본저의
// val lamdaName : Type = {argumentList -> codeBody}

// (input) -> (output)
val square : (Int) -> (Int) = {number -> number*number}

val nameAge = {name : String, age : Int ->
    "my name is ${name} I'm ${age}"
}

fun main() {
    println(square(12))
    println(nameAge("minuk", 26))

    val a = "minuk said"
    val b = "cook said"
    println(a.pizzaIsGreat())
    println(b.pizzaIsGreat())
    println(extendString("minux", 26))
    println(calculateGrade(99))

    val lamda = {number : Double ->
        number == 4.3213
    }

    println(invokeLamda(lamda))
}

// 확장함수
val pizzaIsGreat : String.() -> String = {
    this + "Pizza is the best!"
}

fun extendString(name : String, age : Int) : String{
    val introduceMyself : String.(Int) -> String = {
        "I am ${this} and ${it}" // Int 하나만 파라미터이기에 it 써도 괜찮
    }

    return name.introduceMyself(age)
}

// 람다의 return

val calculateGrade : (Int) -> String = {
    when(it) {
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100 -> "perfect"
        else -> "Error"
    }
}

fun invokeLamda(lamda : (Double) -> Boolean) : Boolean {
    return lamda(5.2343)
}

