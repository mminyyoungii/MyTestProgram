package com.example.mytestprogram

//1. 람다
//value 처럼 사용할 수 있따. -> 1. 메소드의 파라미터로 넘겨줄 수 있음
//2. return 값으로 사용할 수 있다.

//람다의 기본 정의
// val lamdaName: Type ={argumentList-> codeBody}

val square:(Int)->Int={number->number*number}
        //param->return
//val nameAge:(String,Int)->String={~~}     입력값과 리턴값이 추론 가능함으로 생략 가능하다
val nameAge={name : String, age : Int->
    "My name is ${name} I'm ${age}"     //항상 마지막꺼가 리턴
}
fun main() {
    println(square(12))
    println(nameAge("Minyoung",17))
    val a="M said "
    val b="Mac said "
    println(a.pizzaIsGreat())
    println(b.pizzaIsGreat())
    println(extendString("ariana",89))
    println(calculateGrade(97))

    val lamda:(Double)->Boolean={number:Double->
        number==4.3213
    }
    println(invokeLamda(lamda)) //위의 식을 사용함 간접적?
    println(invokeLamda({true}))
    println(invokeLamda({it>1.22})) //람다를 직접적으로 it은 파라미터
    println(invokeLamda { it>1.22 }) //위에 꺼랑 같은거임 == fun(함수)의 마지막 파라미터가 람다 식일때는 이렇게 소괄호가 생략 가능하다. 중요중요중요

}

//확장함수
//밑의 함수는 익명 함수임 또 String 함수를 확장함
// String.() param이 없다는 뜻
val pizzaIsGreat:String.()->String={
    this+"Pizza is the Best!"   //이게 리턴값
}

fun extendString(name: String, age: Int) : String {
//람다 식으로
    val introMyself: String.(Int)->String={
        "I am ${this} and ${it} yeaers old"
    }    //Int를 파라미터로 받고, String을 리턴받음 이렇게 파라미터가 하나일 때는 it으로 받을 수 있다.
    //this는 확장 함수가 불러줄 오브젝트, it은 유일하게 받은 파라미터 int
    return name.introMyself(age)
}

//람다의 Return
//마지막 한줄이 리턴값을 의미한다.
//**input 파라미터는 항상 소괄호 해주기! 리턴값은 안해줘도 된다.
val calculateGrade:(Int) ->String = {
    when(it){
        in 0..40->"fail"
        in 41..70->"pass"
        in 71..100->"perfect"
        else ->"Error"
        //이 함수는 항상 String을 리턴해야함으로 else문 필수(100이상의 값이 나올 수 있음 )
    }
}

//람다를 표현하는 여러가지 방법
//더블을 받고, bool을 리턴하는 람다 함수를 파라미터로 사용한다.
//이 함수(invokeLamda)자체는 boolean 리턴
fun invokeLamda(lamda:(Double)->Boolean) :Boolean{
    return lamda(5.2343)
}

//익명 내부 함수
//1. 코틀린 인터페이스가 아닌 자바 인터페이스여야 한다.
//2. 그 인터페이스는 딱 하나의 메소드만 가져야 한다.


//2. Dataclass
//pojo class 비어있는, 틀 역할을 하는 클래스
//말 그대로 data를 담는 클래쓰
