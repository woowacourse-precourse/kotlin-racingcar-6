package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import racingcar.domain.Car
import racingcar.domain.Winner


fun main() {
    val cars = mutableListOf<Car>()
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    var carNames = Console.readLine().split(",").toMutableList()
    for (carName in carNames) {
        throwExceptionOverFive(carName)
        cars.add(Car(carName))
    }
    println("시도할 횟수는 몇 회인가요?")
    var repeat:Int = Console.readLine().toInt()
    println()
    println("실행 결과")
    for (i in 0..<repeat) {
        moveCars(cars)
        println()
    }
    var winner = Winner(cars)
    winner.print()
}
fun throwExceptionOverFive(name:String){
    if (name.length > 5) {
        throw IllegalArgumentException()
    }
}
fun moveCars(cars:MutableList<Car>){
    for (car in cars) {
        car.move(Randoms.pickNumberInRange(0, 9))
        car.print()
    }
}