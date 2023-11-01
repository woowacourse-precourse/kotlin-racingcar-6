package racingcar

class RacingGame(private val cars: List<Car>, private val tryCount: Int) {

    fun playGame() {
        PrintUtils.printGameIntroduction()
        repeat(tryCount) {
            playRound()
        }
        printWinners()
    }

    private fun playRound() {
        val roundResults = mutableListOf<String>()
        cars.forEach { car ->
            car.move()
            roundResults.add(car.toString())
        }
        PrintUtils.printRoundResults(roundResults)
    }

    fun printWinners() {
        val maxPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position == maxPosition }
        val winnerNames = winners.joinToString(", ") { it.name }
        PrintUtils.printWinners(winnerNames)
    }
}
