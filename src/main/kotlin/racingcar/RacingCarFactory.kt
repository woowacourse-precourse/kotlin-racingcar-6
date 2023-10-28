package racingcar

class RacingCarFactory {
     fun createCars(cars : MutableList<Car>, names: MutableList<String>) {
        for(name in names) {
            cars.add(Car(name, 0))
        }
    }
}