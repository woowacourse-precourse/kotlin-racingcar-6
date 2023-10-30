package racingcar

class Game(private val cars: List<Car>, private val numberOfMoves: Int) {
    fun runGame() {
        repeat(numberOfMoves) {
            for(car in cars) {
                car.move()
            }
            printRoundResult()
        }
        printWinners()
    }

    private fun printRoundResult() {
        for (car in cars) {
            println("${car.name} : ${car.printPosition()}")
        }
    }

    private fun printWinners() {
        val maxPosition = cars.maxByOrNull { it.position }?.position
        val winners = cars.filter { it.position == maxPosition }.map { it.name }
        println("최종 우승자 : ${winners.joinToString(", ")}")
    }
}