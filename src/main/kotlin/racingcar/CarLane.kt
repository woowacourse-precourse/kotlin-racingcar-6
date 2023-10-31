package racingcar

class CarLane(carNames: List<String>) {
    private var cars:MutableList<Car> = arrayListOf()

    init {
        carNames.forEach{
            val car = Car(it)
            cars.add(car)
        }
    }

    fun getCars():List<Car>{
        return cars
    }

    fun runCars(){
        cars.forEach{
            it.moveForward()
        }
        println()
    }

    fun showLap() {
        cars.forEach {
            val lapResult = it.getNameAndCluster()
            println(lapResult)
        }
    }

    fun judgeWinner(): List<String>{
        val maxDistance = getMaxDistance()
        return cars.filter { it.getDistance() == maxDistance }.map { it.getName() }
    }

    private fun getMaxDistance():Int{
        val winnerCar = cars.maxBy{ it.getDistance() }
        return winnerCar.getDistance()
    }

}