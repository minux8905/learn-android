package com.example.learnkotlin.kotlin

data class Ticket(val companyName : String, val name : String, var date : String, var seatNumber : Int)
// toString(), hashCode(), equals(), copy() 등 내용을 자동으로 보여준다

class TicketNormal(val companyName : String, val name : String, var date : String, var seatNumber : Int)



fun main(){
    val ticket = Ticket("a", "b", "c", 14)
    val ticketNormal = TicketNormal("a", "b", "c", 14)

    println(ticket)
    println(ticketNormal)
}