package com.example.learnkotlin.kotlin

class Book private constructor(val id : Int, val name : String){


    companion object BookFactory : IdProvider{
        val myBook = "name"

        fun create() = Book(getId(), myBook)

        override fun getId(): Int {
            return 444
        }
    }
}

interface IdProvider{
    fun getId() : Int
}

fun main(){
    val book = Book.create()

    val bookId = Book.BookFactory.getId()
    println("${book.id} ${book.name}")
}