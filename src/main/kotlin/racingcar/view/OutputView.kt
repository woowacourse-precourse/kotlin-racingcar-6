package racingcar.view

import racingcar.domain.car.dto.output.CarsDto
import racingcar.domain.car.dto.output.WinnersDto

var IS_START_LINE_RENDERED = false

class OutputView {
    fun printRoundResult(carsDto: CarsDto) {
        printStartLineOnce()
        val rendered = carsDto.cars
            .map {
                "${it.name} : ${"-".repeat(it.distance.toInt())}"
            }.joinToString("\n")
        println("$rendered\n")
    }

    fun printWinners(winnersDto: WinnersDto) {
        val winnerNames = winnersDto.winners
            .map { it.name }.joinToString(", ")
        print("최종 우승자 : $winnerNames")
    }

    private fun printStartLineOnce() {
        if (!IS_START_LINE_RENDERED) {
            IS_START_LINE_RENDERED = true
            println("실행 결과")
        }
    }
}
