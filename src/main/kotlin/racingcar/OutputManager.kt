package racingcar

object OutputManager {

    fun printGameStatus(cars:List<Car>) {
        cars.forEach{
            val distanceBar = "-".repeat(it.position)
            println("${it.name} : $distanceBar")
        }
        println()
    }

    fun printWinners(winners:List<Car>) {
        val winnersString = winners.joinToString(", ") { it.name }
        println("최종 우승자 : $winnersString")
    }
}
