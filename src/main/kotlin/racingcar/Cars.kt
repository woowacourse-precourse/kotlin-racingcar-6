package racingcar

class Cars {

    private val cars = CarsBuilder().create()

    fun getCars(): List<Car> {
        return cars
    }
}