package racingcar

class RacingCarGameViewer {

    fun showResultsTitle() {
        println(RESULTS_TITLE)
    }

    fun showRoundResult(racingCars: List<RacingCar>) {
        racingCars.map { racingCar -> println(getMoveResult(racingCar)) }
        print(END_OF_ROUND_RESULT)
    }

    private fun getMoveResult(racingCar: RacingCar): String {
        return racingCar.getName() + BLANKED_COLON + DASH.repeat(racingCar.getPosition())
    }

    fun showWinners(racingCars: List<RacingCar>) {
        val winners = getWinners(racingCars)

        if (winners.size == 1) println(getWinnerMessage(winners[0]))
        else println(getWinnersMessage(winners))
    }

    private fun getWinners(racingCars: List<RacingCar>): List<RacingCar> {
        val winners = mutableListOf<RacingCar>()
        val maxPosition = racingCars.maxOf { racingCar -> racingCar.getPosition() }

        racingCars.map { racingCar -> if (racingCar.getPosition() == maxPosition) winners.add(racingCar) }

        return winners
    }

    private fun getWinnerMessage(winner: RacingCar): String {
        return WINNER + BLANKED_COLON + winner.getName()
    }

    private fun getWinnersMessage(winners: List<RacingCar>): String {
        return WINNER + BLANKED_COLON + winners.joinToString(WINNER_SEPARATOR) { winner -> winner.getName() }
    }


    companion object {
        private const val RESULTS_TITLE = "\n실행 결과"
        private const val BLANKED_COLON = " : "
        private const val DASH = "-"
        private const val END_OF_ROUND_RESULT = "\n"
        private const val WINNER = "최종 우승자"
        private const val WINNER_SEPARATOR = ", "
    }
}