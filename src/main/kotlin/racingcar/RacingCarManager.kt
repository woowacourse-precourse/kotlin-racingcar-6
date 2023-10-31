package racingcar

class RacingCarManager {
    fun moveAllCars(cars: List<RacingCar>) {
        for(car in cars) {
            car.move()
        }
    }
}