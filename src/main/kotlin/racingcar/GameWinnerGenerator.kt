package racingcar

class GameWinnerGenerator(private val cars: List<Car>) {

    fun result() {
        printWinners(findWinners())
    }

    private fun findWinners(): List<Car> {
        val highestScore = cars.maxByOrNull { it.scoreSum }?.scoreSum
        return cars.filter { it.scoreSum == highestScore }
    }

    private fun printWinners(winners: List<Car>) {
        val nameList = winners.map { it.name }
        println(nameList.joinToString(","))
    }
}