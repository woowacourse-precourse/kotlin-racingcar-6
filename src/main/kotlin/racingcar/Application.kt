package racingcar

import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

fun main() {
    val cars = mutableListOf<Car>()
    var repeat:Int
    var exception = MyException()

    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    var carNames = Console.readLine().split(",").toMutableList()
    for (carName in carNames) {
        exception.throwNameEmptyException(carName)
        exception.throwNameOverFiveException(carName)
        exception.throwNameOneException(carName)

        var car = Car(carName)
        cars.add(car)
    }
    println("시도할 횟수는 몇 회인가요?")
    try{
        repeat = Console.readLine().toInt()
    }catch (e:IllegalArgumentException){
        throw e
    }


    println()
    println("실행 결과")
    for (i in 0..<repeat) {
        moveCar(cars)
        println()
    }
    var race = Race(cars)
    print(race.getOutput())
}

fun moveCar(cars:MutableList<Car>){
    for (car in cars) {
        car.move()
        print(car.getOutput())
    }
    println()
}



