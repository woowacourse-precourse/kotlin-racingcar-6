package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val cars = mutableListOf<Car>()
    var repeat:Int

    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    var carNames = Console.readLine().split(",").toMutableList()
    for (carName in carNames) {
        var car = Car()
        car.name = carName
        car.isValid()
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
        moveCars(cars)
        println()
    }
    var winner = Winners(cars)
    print(winner.getOutput())
}



fun moveCars(cars:MutableList<Car>) {
    for (car in cars) {
        car.move(Randoms.pickNumberInRange(0, 9))
        print(car.getOutput())
    }
}