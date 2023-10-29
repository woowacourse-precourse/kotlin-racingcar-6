package racingcar

class CarLane {
    private var cars:MutableList<Car> = arrayListOf()
    constructor(carNames:List<String>){
        carNames.forEach{
            var car = Car(it)
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
            it.showDistanceWithName()
        }
    }

    fun judgeWinner(): List<String>{
        var maxDistance = getMaxDistance()
        return cars.filter { it.getDistance() == maxDistance }.map { it.getName() }
    }

    fun getMaxDistance():Int{
        var winnerCar = cars.maxBy{ it.getDistance() }
        return winnerCar.getDistance()
    }

}