package racingcar

class RacingCarManager {
    fun moveAllCars(cars: MutableList<RacingCar>) {
        for(car in cars) {
            car.move()
        }
    }
}