package com.example.mytestprogram

//Object

//singleton Pattern
object CarFactory{  //클래스와 다른점: carfactory라는 객체는 이 모든 어플을 실행할 동안 only 한번 만들어진다.->메모리 낭비를 줄일 수 있다.
    val cars= mutableListOf<Car>()
    fun makeCar(horsePower: Int):Car{
        val car=Car(horsePower)
        cars.add(car)
        return car
    }
}
 data class Car(val horsePower:Int)

fun main() {
    val car=CarFactory.makeCar(10)
    val car2=CarFactory.makeCar(200)

    println(car)
    println(car2)
    println(CarFactory.cars.size.toString())
}