package com.example.mytestprogram

//2. Dataclass
//pojo class 비어있는, 틀 역할을 하는 클래스
//말 그대로 data를 담는 클래쓰

data class Ticket(val companyName:String, val name: String, var date: String, var seatNumber: Int)
//toString(),hashCode(),equals(),copy()가 생성된다.

class TicketNormal(val companyName:String, val name: String, var date: String, var seatNumber: Int)
fun main() {
    val ticketA=Ticket("KoreanAir","Minyy","2020_02_20",15)
    val ticketB=TicketNormal("KoreanAir","Minyy","2020_02_20",15)

    println(ticketA)    //출력문 두 개 비교해보기 -> 객체의 내용이 보여짐 ->dataclass 의 장점 편리하다.
    println(ticketB)    //주소가 보여짐
}