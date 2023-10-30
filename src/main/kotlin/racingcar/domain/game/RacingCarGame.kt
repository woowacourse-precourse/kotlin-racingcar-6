package racingcar.domain.game

import racingcar.domain.computer.Computer

class RacingCarGame(private val carMap: MutableMap<String, Int>) {
    fun play(count: Int) {
        repeat(count) {
            carMap.forEach { (carName, score) ->
                carMap[carName] = score + Computer.forwardCar()
            }
        }
    }
}
