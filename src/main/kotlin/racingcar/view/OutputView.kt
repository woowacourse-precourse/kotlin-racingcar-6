package racingcar.view

import racingcar.*
import racingcar.dto.CarDto
import racingcar.dto.WinnerDto
import racingcar.exceptions.UnvalidPositionException

class OutputView {
    fun raceStart() {
        println(OUTPUT_MESSAGE_RACE_RESULT)
    }

    fun printRound(carDTOList: MutableList<CarDto>) {
        carDTOList.forEach {carDTO ->
            println(carDTO.getCarName() + OUTPUT_MESSAGE_DIVIDER + createDistanceStringFromPosition(carDTO.getPositionNumber()))
        }
        print(OUTPUT_MESSAGE_NEWLINE)
    }

    fun printWinner(winnerDTOList: MutableList<WinnerDto>) {
        print(OUTPUT_MESSAGE_WINNER_ANNOUNCE)
        winnerDTOList.forEachIndexed {index, winnerDTO ->
            print(winnerDTO.getWinnersName())
            if (index != winnerDTOList.count() - 1) {
                print(SEPARATOR_WITH_SPACE)
            }
        }
    }

    private fun createDistanceStringFromPosition(value: Int): String {
        if (value < 0)
            throw UnvalidPositionException()

        return buildString {
            append('-'.toString().repeat(value))
        }
    }
}