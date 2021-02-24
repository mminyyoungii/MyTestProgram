package com.example.mytestprogram

fun main() {
 nullcheck()
}

//4. 조건식
fun maxBy(a:Int, b:Int):Int {
    if(a>b)
        return a
    else return b

}
fun maxBy2(a:Int, b:Int) =if(a>b) a else b  //삼항 연산자-> 리턴값 생략 가능
// If 만큼 자주사용되는 조건문 When

fun checkNum(score : Int)
{
    when(score) //switch문 같은거
    {
        0->println("This is 0")
        1->println("This is 1")
        2,3->println("This is 2 or 3")  //또는
        else->println("I don't know")   //else 문이 없어도 된다
    }
    var b:Int=when(score)   //리턴식으로 쓰일 수 있음-> 항상 else 문 필요함
    {
        1->1
        2->2
        else -> 3
    }
    println("b: ${b}")

    when(score)
    {
        in 90..100->println("You are genius")
        in 10..80->println("not bad")
        else -> println("okay")
    }
}
//5. Array vs List
//array는 기본적으로 정해진 size가 있음. 처음에 크기를 지정해 줘야함
//List(수정 불가능한 리스트 ) Vs MutableList(수정 가능한 리스트 )

fun array()
{
    val array:Array<Int> = arrayOf(1,2,3)
    val list:List<Int> = listOf(1,2,3)

    val array2= arrayOf(1,"d",3.4f) //Array<Any>   타입으로 추론
    val list2=listOf(1,"d",11L) //List<Any> 타입으로 추론

    array[0]=3
    //list[0]=2 -> list는 읽기 전용, 값을 바꿀 수는 없음 !!!!!!!! array와 다르게 인터페이스임

    var arrayList:ArrayList<Int> = arrayListOf<Int>()
    arrayList.add(10)
    arrayList.add(20)
}


//6. 반복문
fun forAndWhile()
{
    val student=arrayListOf("A","BC","DEF","Hello")
    for(name in student)
    {
        println("${name}")
    }

    var sum:Int =0
    for(i in 1..10)
    {
        sum+=i
    }
    println(sum)
    for(i in 1..10 step 2)  //2칸씩 더함
    {
        sum+=i
    }

    for(i in 10 downTo 1)
    {
        //숫자 내려가면서 반복
    }
    for(i in 1 until 100)
    {
        //1..100과의 차이점은 until은 100은 더하지 않음-> 99번 더해짐
        //1..100은 100번 돈다
   }

    var index=0
    for((index:Int, name:String) in student.withIndex())    //index 와 name을 같이 사용
    {
        println("${index}번째 학생: ${name}")
    }

    while(index<10)
    {
        println("cur_index: ${index}")
        index++
    }


}
//7. NonNull / Nullable
fun nullcheck()
{
    //NPE:NUll point Exception ->자바에서 런타임 에러가 난다.
    //코틀린에서는 이를 컴파일 시점에 알 수 있다

    var name: String= "Minyoung"
    var nullName: String?=null  //?를 넣어 줌으로써 NULLable 가능해짐
                        //nullable이란 null값이 허용 안되는 자료형에 null을 가능하게 함
                        //nullable 하게 하려면 타입을 지정해 줘야 함

    var nameInUpperCase:String = name.toUpperCase()// 대문자로 만들어짐 null 이 아니니까 사용 가능함
    var nullNameInUpperCase:String? = nullName?.toUpperCase() //물음표를 붙여야 함 널이면 널 반환 아니면 대문자로 반환

    //?:엘비스 연산자
    val lastName : String? =null
    val fullName= name+" "+(lastName?:"No lastName")   //lastname 이 없으면 뒤의 문자열을 출력하고
                                                        //lastname이 있으면 있는거 출력
    println(fullName)

}

//!!:nullable로 선언 되어있지만 널 아니라고 컴파일에게 말해주는거거

fun ignoreNull(str:String?)
{
    val notNUll: String=str!!
    val upperCase= notNUll.toUpperCase()    //널이 아니라고 말해줬기 때문에 사용가능하다

    val email:String?="wds0107@naver.com"
    //let 함수 밑의 문장: email이 null이 아니면 let안에 구문 실행할것
    email?.let{
        //email 대신 it으로 지정해줘도 된다.
        println("my email is ${email}")
    }
}

