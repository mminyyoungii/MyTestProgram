package com.example.mytestprogram

//코틀린은 파일 이름과 클래스 이름이 달라도 된다.
//코틀린은 하나의 파일에 여러가지 클래스가 들어갈 수 있다.

//open class Human constructor(id:String){ //이 constructor가 주 생성자인듯
    //생성자에 default값을 줄 수도 있음
    //constructor(id:String="HEllO")-> 이런식으로 생성자에 기본값을 주면 입력받을 때 id를 입력받지 않아도
    //객체가 생성될 수 있다.
open class Human constructor(id:String="aaaa"){
    //밑에줄의 constructor는 부 생성자로 항상 주 생성자의 위임을 받아야 한다
    // 오버로딩 느낌인듯

    constructor(id: String, age:Int): this(id)  //this가 위임받는거
    {
        println("My id is ${id}, ${age} years old")
    }
    init{   //주 생성자의 일부 -> 부생성자보다 항상 먼저 생긴다.
        //없어도 된다
        //처음 객체가 생성되었을 때 어떤 동작을 하고싶은지 적으면 된다.
        println("New Human has been born!")
    }
    val id=id
    val name="Minyoung"//객체를 생셩하며 이름을 받고싶을 떄는 constructor(생성자)를 이용하면 된다.
    fun eatingCake(){
        println("So Yummy!");
    }
    open fun singAsong()
    {
        println("lalala")
    }
}

//상속받기
//:상속받을 클래스명
//기본적으로 코틀린은 final class 이다. 따라서 아무리 같은 파일이여도 침범 불가 -> open을 해줘야 한다.
//상속은 오버라이딩 느낌으로다가
//상속은 하나만 가능하다.
class Korean: Human()
{
    //상속받은 것 오버라이딩 하기
    override fun singAsong()
    {
        super.singAsong()   //부모 꺼도 사용하고싶을 때
        println("랄랄라")
        println("My id is ${id}")
    }
}
fun main() {
    val human = Human("minsu")
    human.eatingCake()
    val mom=Human("Minssu",31)
   // println("His name is ${human.name}")
   // println("ID is ${human.id}")
    val korean=Korean() //부모의 init-> New Human has been born 출력된다.
    korean.singAsong()//부모 클래스 상속한거니까 사용할 수 있다
                        //
}