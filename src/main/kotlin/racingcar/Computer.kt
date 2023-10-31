package racingcar

class Computer() {

    fun printWinner(cars: List<Car>) {
        var status = WINNER
        val position = arrayListOf<Int>()
        cars.forEach { car ->
            position.add(car.position)
        }
        val winnerPosition = position.max()
        val winner = cars.filter { it.position == winnerPosition }
        winner.forEach { car ->
            status += "${car.name}, "
        }
        println(status.substring(0, status.length - 2))
    }

    fun printResult(roundCount: Int, cars: List<Car>) {
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