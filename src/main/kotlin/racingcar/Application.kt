package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val cars = mutableListOf<Car>()

    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    var carNames = Console.readLine().split(",").toMutableList()
    for (carName in carNames) {
        var car = Car(carName)
        cars.add(car)
    }
    println("시도할 횟수는 몇 회인가요?")
    var repeat = Console.readLine().toInt()

    println()
    println("실행 결과")
    for (i in 0..<repeat) {
        for (car in cars) {
            car.move(Randoms.pickNumberInRange(0, 9))
            print(car.getOutput())
        }
        println()
    }
    var race = Race(cars)
    var winner = race.getWinners()
    print(race.getOutput())

//    val cars = mutableListOf<Car>()
//    var repeat:String
//    var exception = MyException()
//
//    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
//    var carNames = Console.readLine().split(",").toMutableList()
//    for (carName in carNames) {
//        exception.throwNameEmptyException(carName)
//        exception.throwNameOverFiveException(carName)
//        var car = Car()
//        car.name = carName
//        cars.add(car)
//    }
//    println("시도할 횟수는 몇 회인가요?")
//    repeat = Console.readLine()
//    exception.throwRepeatEmptyException(repeat)
//    exception.throwRepeatStringException(repeat)
//
//    println()
//    println("실행 결과")
//    for (i in 0..<repeat.toInt()) {
//        for (car in cars) {
//            car.move(Randoms.pickNumberInRange(0, 9))
//            print(car.getOutput())
//        }
//        println()
//    }
//    var winner = Winners(cars)
//    print(winner.getOutput())
}





