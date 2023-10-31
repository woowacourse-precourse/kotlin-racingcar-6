package racingcar.domain.game

import racingcar.domain.Constants
import racingcar.domain.computer.Computer
import racingcar.view.OutputView

class RacingCarGame(private val carMap: MutableMap<String, Int>) {
    fun play(count: Int) {
        OutputView.runMessage()
        repeat(count) {
            carMap.forEach { (carName, score) ->
                carMap[carName] = score + Computer.forwardCar()
                OutputView.showResult(carName, carMap[carName]!!)
            }
            println()
        }
        getWinners().let {
            OutputView.showWinners(it)
        }
    }

    private fun getWinners(): List<String> {
        val maxScore = carMap.values.maxOrNull() ?: throw IllegalArgumentException(Constants.EMPTY_INPUT_ERROR_MESSAGE)
        return carMap.filter { it.value == maxScore }.keys.toList()
    }
}
