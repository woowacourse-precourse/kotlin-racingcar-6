package racingcar.domain.game

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
    }
}
