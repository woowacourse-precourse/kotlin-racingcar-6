package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    val cars = mutableListOf<Car>()
    var exception = MyException()

    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    var carNames = Console.readLine().split(",").toMutableList()
    for (carName in carNames) {
        exception.throwNameEmptyException(carName)
        exception.throwNameOverFiveException(carName)

        var car = Car(carName)
        cars.add(car)
    }
    println("시도할 횟수는 몇 회인가요?")
    var repeat = Console.readLine().toInt()

    println()
    println("실행 결과")
    for (i in 0..<repeat) {
        for (car in cars) {
            car.move()
            print(car.getOutput())
        }
        println()
    }
    var race = Race(cars)
    var winner = race.getWinners()
    print(race.getOutput())

}





