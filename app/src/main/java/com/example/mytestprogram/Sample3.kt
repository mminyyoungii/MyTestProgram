package com.example.mytestprogram

//Companion Object ->자바의 static 개념과 비슷함

class Book private constructor(val id:Int, val name: String)    //private const를 사용하여 다른곳에서는 객체를 만들지 못하도록 한다.
{
   companion object bookFactory{    ///companion에 이름을 붙일 수 있음 (안붙여도 된다. )또 상속도 가능하다.
       //override fun getId(): Int{
    //       return 444
     //  }
       val myBook="new Book"
       fun create()=Book(0,"animal farm")
   }
}
interface IdProvider{
    fun getId():Int
}

fun main()
{
  //  val book:Book=Book.Companion.create()   //companion 생략 가능
   // println("${book.id} ${book.name}")

    val book :Book =Book.create()
    val bookId:Int=Book.bookFactory.getId()
    println("${book.id} ${book.name}")
}