package racingcar.domain

import racingcar.constant.ErrorMessage
import racingcar.constant.ExtraChar
import racingcar.constant.PrintText


class RacingCars(names: List<String>) {
    private var racingCars: List<RacingCar>? = null

    init {
        validateNameListSize(names)
        validateNameLength(names)
        racingCars = names.map { RacingCar(it) }
    }

    fun toRacingCarsAttemptResult(): String {
        val racingCarsResult = StringBuilder()
        racingCars!!.forEach {
            racingCarsResult.append(it.readRacingCarName() + PrintText.SEPARATE_CAR_NAME_AND_FORWARD_COUNT.text)
            repeat(it.readForwardCount()) {
                racingCarsResult.append(PrintText.PRINT_FORWARD_MARK.text)
            }
            racingCarsResult.append(ExtraChar.NEWLINE.text)
        }
        return racingCarsResult.toString()
    }

    fun moveRacingCars(randomNumbers: List<Int>) {
        racingCars!!.forEachIndexed { index, racingCar ->
            racingCar.moveRacingCar(randomNumbers[index])
        }
    }

    fun calculateWinner(): RacingGameWinners {
        val fastestPosition: Int = racingCars!!.maxOf { it.readForwardCount() }
        val winners = racingCars!!.filter { it.readForwardCount() == fastestPosition }
        val winnerNames = mutableListOf<String>()
        winners.forEach { winnerNames.add(it.readRacingCarName()) }
        return RacingGameWinners(winnerNames)
    }

    fun racingCarsSize() = racingCars!!.size

    private fun validateNameListSize(names: List<String>) {
        require(names.size >= MIN_RACING_CAR_COUNT) { ErrorMessage.RACING_CAR_LESS_THAN_TWO.message }
    }

    private fun validateNameLength(names: List<String>) {
        require(
            names
                .none { it.length > MAX_NAME_LENGTH }) { ErrorMessage.NAME_LENGTH_GREATER_THAN_FIVE.message }
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
        private const val MIN_RACING_CAR_COUNT = 2
    }

}