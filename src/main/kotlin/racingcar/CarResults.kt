package racingcar

object CarResults {
    fun printCurrentPositions(carNames: List<String>, carPositions: IntArray) {
        for (i in 0 until carNames.size) {
            println("${carNames[i]} : ${"-".repeat(carPositions[i])}")
        }
        println()
    }

    fun findWinners(carNames: List<String>, carPositions: IntArray): List<String> {
        val maxPosition = carPositions.max()
        return carNames.filterIndexed { index, _ -> carPositions[index] == maxPosition }
    }

    fun printWinners(winners: List<String>) {
        println("최종 우승자: ${winners.joinToString(", ")}")
    }
}
