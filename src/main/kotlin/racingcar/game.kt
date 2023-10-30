package racingcar

class Game (private val cars: List<Car>, private val rounds: Int) {
    fun start() {
        println("실행 결과")
        repeat(rounds) {
            for (Car in cars) {
                Car.advancePosition()
                Car.printCarData()
                println("")
            }
        }
        val winners = findWinners()
        printWinners(winners)
    }

    private fun findWinners(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }

    private fun printWinners(winners: List<Car>) {
        val winnerNames = winners.joinToString(", ") { it.name }
        println("최종 우승자: $winnerNames")
    }
}