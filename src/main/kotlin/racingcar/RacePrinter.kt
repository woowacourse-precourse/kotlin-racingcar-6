package racingcar

import racingcar.GameMessage.WINNER_MESSAGE

object RacePrinter {
    private const val DASH = "-"
    private const val COLON = " : "
    private const val COMMA = ", "

    fun showCurrentRace(cars: List<Car>) {
        cars.map { car ->
            println(car.name + COLON + DASH.repeat(car.position))
        }
        println()
    }

    fun showWinners(winners: List<Car>) {
        val winnerNames = winners.joinToString(COMMA) { it.name }
        println(WINNER_MESSAGE + winnerNames)
    }
}
