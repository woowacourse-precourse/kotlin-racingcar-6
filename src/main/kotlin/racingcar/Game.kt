package racingcar

class Game(private val view: View) {
    private val cars = mutableListOf<Car>()

    fun playGame(names: List<String>, times: Int) {
        createCars(names)
        for (i in 1..times) {
            moveCars()
            view.printPosition(cars)
        }
        val winnerList = makeWinnerList(getLeadPosition())
        view.printWinner(winnerList)
    }

    private fun createCars(names: List<String>) {
        names.forEach {
            cars.add(Car(it))
        }
    }

    private fun moveCars() {
        cars.forEach { car ->
            val num = car.generateRandomNumber()
            car.updatePosition(car.judgeNumber(num))
        }
    }

    private fun getLeadPosition(): Int {
        return cars.maxOf { it.getPositionNumber() }
    }

    private fun makeWinnerList(leadPosition: Int): List<String> {
        return cars.filter { it.getPositionNumber() == leadPosition }.map { it.getName() }
    }
}