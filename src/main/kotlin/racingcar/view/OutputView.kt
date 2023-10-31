package racingcar.view

import racingcar.model.RacingCar

class OutputView {
    fun printResultMessage() = println("\n실행 결과")

    fun printResult(racingCars: List<RacingCar>) : String {
        val result = StringBuilder()
        for (car in racingCars)
            result.append("${car.name} : ").append("-".repeat(car.forward)).append("\n")
        return result.toString()
    }

    fun printWinnerMessage() = print("최종 우승자 : ")

    fun printWinner(winnerCars: List<String>) : String = winnerCars.joinToString(", ")

}