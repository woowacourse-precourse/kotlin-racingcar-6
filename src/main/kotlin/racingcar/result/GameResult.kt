package racingcar.result

import racingcar.car.Cars

class GameResult {
    fun showWinners(cars: Cars) {
        print(WINNER_INFO)
        printWinners(Winner(cars.getCars()).getWinners())
    }

    private fun printWinners(winners: List<String>) {
        println(winners.joinToString(","))
    }

    companion object {
        const val WINNER_INFO = "최종 우승자 : "
    }
}