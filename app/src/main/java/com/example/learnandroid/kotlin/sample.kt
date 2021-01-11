package com.example.learnkotlin.kotlin

fun main() {
//    helloWorld()
//
//    println(add(4, 5))

    //3. String Template
/*    val name = "minuk"
    val lastName = "Yu"
    println("my name is ${name + lastName} I'm 26")

    println("is this true? ${1 == 0}")

    println("this is 2\$")*/

//    checkNum(1)
    forAndWhile()
}

// 1. 함수
fun helloWorld() : Unit {
    println("Hello World")
}

fun add(a : Int, b : Int) : Int {
    return a + b
}

//2. val vs var
//val = value 상수 변하지 않는 값

fun hi(){
    val a : Int = 10

    //a = 5 error

    var b : Int = 10

    b = 5

    var c = 10
    val d = 10

    val name = "minuk"
}

//4. 조건식

fun maxBy(a : Int, b : Int) : Int {
    if( a > b){
        return a
    }else{
        return b
    }
}

fun maxBy2(a : Int, b : Int) = if( a > b) a else b

fun checkNum(score : Int) : Unit{
    //Statement
    when(score){
        0 -> println("this is 0")
        1 -> println("this is 1")
        2, 3 -> println("this is 2 or 3")
        else -> println("I don't know")
    }

    var b = when(score){
        1-> 1
        2-> 2
        else -> 3
    }

    println("b : ${b}")

    when(score){
        in 90..100 -> println("You are genius")
        in 10..80 -> println("not bad")
        else -> println("okay")
    }
}

// Expression vs Statement
//코틀린에서 모든 함수는 expression이다. 값을 반환하기 때문에
//Statement 단지 뭔가를 해 명령

//5. Array and List
// Array 정적인 메모리
// List 1. List(수정 불가) 2. MutableList(수정 가능)
fun array(){
    val array : Array<Int> = arrayOf(1, 2, 3) // array 초기화
    val list : List<Int> = listOf(1, 2, 3) // list 초기화

    val array2 = arrayOf(1, "d" , 3.4f)
    val list2 = listOf(1, "d", 11L)

    array[0] = 3
    //list[0] = 2 불가
    list.get(0)

    val arrayList = arrayListOf<Int>()
    arrayList.add(10)
    arrayList.add(20)
}


// 6. For / While

fun forAndWhile(){
    val students = arrayListOf("joyce", "james", "jenny", "jennifer")

    for (name in students){
        println("${name}")
    }

    for((index, name) in students.withIndex()){
        println("${index}번째 학생 :  ${name}")
    }

    var sum : Int = 0
    for (i in 1..10){
        sum += i
    }

    for (i in 1..10 step 2){ // 1 3 5 7 9
        sum += i
    }

    for( i in 10 downTo 1) { // 10 9 8 7 .. 1
        sum += i
    }

    for( i in 1 until 100) { // 1 2 .. 99
        sum += i
    }

    var index = 0
    while(index < 10){
        println("current index : ${index++}")
    }

//    println("sum: $sum")
}

// 7. Nullable / NonNull

fun nullcheck(){
    //NPE  : NULL pointer Exception -> runTime 에서만 잡힘
    // complie 단계에서 Null pointer check
    //NonNull 타입
    var name : String = "minuk" // null 이면 안되는 타입
    var name2 = "minuk"

    // type? '?' 가 붙어지면 Nullable 타입이 된다
    var nullName : String? = null

    var nameInUpperCase = name.toUpperCase()

//    var nullNameInUpperCase1 = nullName.toUpperCase() // 컴파일 단계에서 오류

    var nullNameInUpperCase2 = nullName?.toUpperCase()  // null이면 null을 반환하게 된다. null이 아니면 실행

    // ?: 엘비스 연산자
    val lastName : String? = null

    val fullName = name + " " + (lastName ?: "No lastName") // lastName이 없으면 No lastName 을 반환

    // !! 컴파일러에게 null이 아니라는 것을 보증

}

fun ignoreNulls(str : String?){
    val mNotNull : String = str!! // null이 아니라고 생각해라
    val upper = mNotNull.toUpperCase()

    val email : String? = "minux@gmail.com"

    // let 자신의 receiver객체를 자신의 람다식 내부로 옮겨준다
    email?.let{
        // email이 not null이면 이걸 해라라
        // email이 null이면 println 실행이 되지 않기 때문에 안전하다
        println("my email is ${it}")
    }
}
