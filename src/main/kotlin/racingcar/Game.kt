package racingcar

class Game(private val view: View) {
    private val cars = mutableListOf<Car>()

    fun playGame(names: List<String>, times: Int) {
        createCars(names)
        playGameNTimes(times)
        val winnerList = getWinners()
        view.printWinner(winnerList)
    }

    private fun createCars(names: List<String>) {
        names.forEach {
            cars.add(Car(it))
        }
    }

    private fun moveCars() {
        cars.forEach { car ->
            val randomNumber = car.generateRandomNumber()
            car.updatePosition(car.judgeNumber(randomNumber))
        }
    }

    private fun playGameNTimes(times: Int) {
        view.printResult()
        repeat(times) {
            moveCars()
            view.printPosition(cars)
        }
    }

    private fun getWinners(): List<String> {
        val leadPosition = cars.maxOf { it.getPositionNumber() }
        return cars.filter { it.getPositionNumber() == leadPosition }.map { it.getName() }
    }
}