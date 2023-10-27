package racingcar

import racingcar.Constants.WINNERS

class ResultManager(
    private val racingCars: List<RacingCar>
) {

    fun determineWinners(): List<String> {
        val winners = mutableListOf<String>()
        var maxMoves = 0
        racingCars.onEach {
            if (it.moves > maxMoves) {
                winners.clear()
                maxMoves = it.moves
                winners.add(it.name)
            } else if (it.moves == maxMoves) {
                winners.add(it.name)
            }
        }

        return winners
    }
}