package racingcar

class Round(carNames: List<String>) {
    private var cars: MutableList<Car> = arrayListOf()

    fun initializeAndGetCars(carNames: List<String>): List<Car> {
        carNames.forEach {
            val car = Car(it)
            cars.add(car)
        }
        return cars
    }


    fun move() {
        cars.forEach {
            it.moveForward()
        }
        println()
    }

    fun printRound() {
        cars.forEach {
            val printResult = it.movingState()
            println(printResult)
        }
    }

    fun getWinners(): List<String> {
        val maxPosition = findMaxPosition()
        return cars.filter { it.getPosition() == maxPosition }.map { it.getName() }
    }

    private fun findMaxPosition():Int{
        val winnerCar = cars.maxBy{ it.getPosition() }
        return winnerCar.getPosition()
    }

}

