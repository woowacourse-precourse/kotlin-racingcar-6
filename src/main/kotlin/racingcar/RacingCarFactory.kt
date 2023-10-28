package racingcar

class RacingCarFactory {
     fun createCars(cars : MutableList<RacingCar>, names: MutableList<String>) {
        for(name in names) {
            cars.add(RacingCar(name, 0))
        }
    }
}