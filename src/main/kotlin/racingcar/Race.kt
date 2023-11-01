package racingcar

class Race {

    fun startRace(cars: List<Car>, moveTime: Int) {
        println()
        println("실행 결과")
        repeat(moveTime) {
            cars.forEach { it.moveCar() }
            viewRace(cars)
            println()
        }
        printWinner(decideWinner(cars))
    }

    private fun viewRace(cars: List<Car>) {
        cars.forEach { it.printCarMove() }
    }

    private fun decideWinner(cars: List<Car>): List<String> {
        val maxMove = cars.maxOf { it.moveCount }
        return cars.filter { it.moveCount == maxMove }.map { it.name }
    }

    private fun printWinner(winner: List<String>) {
        println("최종 우승자 : ${winner.joinToString(",")}")
    }
}