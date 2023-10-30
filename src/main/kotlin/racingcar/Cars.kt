package racingcar

class Cars {

    private var cars = listOf<Car>()

    fun init() {
        cars = CarsBuilder().create()
    }

    fun getCars(): List<Car> {
        return cars
    }
}