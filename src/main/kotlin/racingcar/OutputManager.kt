package racingcar

object OutputManager {

    fun printGameStatus(cars:List<Car>) {
        print(buildGameStatusString(cars))
        println()
    }
    private fun buildGameStatusString(cars: List<Car>) = cars.map{
            val distanceBar = "-".repeat(it.position)
            return "${it.name} : $distanceBar"
        }.joinToString("\n")

    fun printWinners(winners: List<Car>) {
        println(buildWinnersString(winners))
    }
    private fun buildWinnersString(winners:List<Car>): String = "최종 우승자 : " + winners.joinToString(", ") { it.name }
}
