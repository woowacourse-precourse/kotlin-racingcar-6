package racingcar

class RacingGame(private val cars: List<Car>, private val tryCount: Int) {

    fun playGame() {
        println("\n실행 결과")
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
        println(roundResults.joinToString("\n"))
        println()
    }

    fun printWinners() {
        val maxPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position == maxPosition }
        val winnerNames = winners.joinToString(", ") { it.name }
        println("최종 우승자: $winnerNames")
    }
}
