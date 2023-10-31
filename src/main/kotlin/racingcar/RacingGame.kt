package racingcar

class RacingGame(private val cars: List<Car>, private val tryCount: Int) {

    fun playGame() {
        println("\n실행 결과")
        repeat(tryCount) {
            playRound()
            println("\n")
        }
        printWinners()
    }

    private fun playRound() {
        cars.forEach { it.move() }
        println(cars.joinToString("\n"))
    }

    private fun printWinners() {
        val maxPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position == maxPosition }
        val winnerNames = winners.joinToString(", ") { it.name }
        println("\n최종 우승자: $winnerNames")
    }
}

