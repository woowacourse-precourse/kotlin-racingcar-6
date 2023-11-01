package racingcar

import racingcar.domain.*

fun main() {

    val input = Input()
    val cars = Cars(DetermineMove())
    val output = Output()

    cars.createCar(input.carName())
    val actionNum = input.attemptNum()
    println("\n실행 결과")
    for (i in 0..<actionNum) {
        cars.moveCars()
        output.printState(cars.carList)
        println()
    }
    output.printResult(cars.getWinnerList())

}
