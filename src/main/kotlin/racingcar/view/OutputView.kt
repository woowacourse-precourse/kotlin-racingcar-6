package racingcar.view

import racingcar.model.RacingCar

class OutputView {
    fun printResultMessage() = println("\n실행 결과")

    fun printResult(racingCars: List<RacingCar>) {
        for (car in racingCars) {
            println("${car.name} : " + "-".repeat(car.forward))
        }
        println()
    }

    fun printWinnerMessage() = print("최종 우승자 : ")

    fun printWinner(winnerCars: List<String>) {
        println(winnerCars.joinToString(", "))
    }
}