package racingcar

class Computer() {

    fun getWinnerStatus(cars: List<Car>): String {
        var status = WINNER
        val winnerPosition = getWinnerPosition(cars)
        val winner = getWinner(cars, winnerPosition)
        winner.forEach { car ->
            status += "${car.name}, "
        }
        return status.substring(0, status.length - 2)
    }

    fun getWinner(
        cars: List<Car>,
        winnerPosition: Int,
    ) = cars.filter { it.position == winnerPosition }

    fun getWinnerPosition(cars: List<Car>): Int {
        val position = arrayListOf<Int>()
        cars.forEach { car ->
            position.add(car.position)
        }
        return position.max()
    }

    fun playGame(roundCount: Int, cars: List<Car>) {
        printResultMessage()
        repeat(roundCount) {
            moveCar(cars)
            printPosition(cars)
            println()
        }
    }

    private fun moveCar(cars: List<Car>) {
        cars.forEach { car ->
            val num = car.generate()
            car.moving(num)
        }
    }

    private fun printPosition(cars: List<Car>) {
        cars.forEach { car ->
            val status = car.getStatus()
            println(status)
        }
    }

    private fun printResultMessage() = println(RESULT_MESSAGE)

    companion object {
        const val WINNER = "최종 우승자 : "
        const val RESULT_MESSAGE = "\n실행 결과"
    }
}