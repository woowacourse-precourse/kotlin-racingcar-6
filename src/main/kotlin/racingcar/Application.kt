package racingcar

import racingcar.domain.*

fun main() {

    val input = Input()
    val cars = Cars(DetermineMove())
    val output = Output(cars)

    cars.createCar(input.carName())
    val actionNum = input.attemptNum()
    println("\n실행 결과")
    for (i in 1..actionNum) {
        cars.moveCars()
        output.printState()
        println()
    }
    output.printResult()

}
