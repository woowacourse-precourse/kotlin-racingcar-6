package racingcar

fun main() {
    println("이름")
    val user = Input()
    val carName = user.inputCarName()
    //println(carName)

    var car: MutableList<Car> = mutableListOf()
    //val car = Car()
    setCar(carName, car)

    val m = Move(car)
    val mm = m.moveCar()


    //val randomNumber = RandomNumber()
    //val randomNum = randomNumber.createRandomNumber() //랜덤수 생성  ex.9

    //val emptyList = emptyList<Int>()

    //println("횟수")
    //val count = user.inputGameNumber()
    //println("결과")
}
fun setCar(carName: MutableList<String>, car: MutableList<Car>) {
    for (i in carName) {
        car.add(Car(name = i.toString()))
    }
}
