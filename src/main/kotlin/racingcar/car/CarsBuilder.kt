package racingcar.car

class CarsBuilder {
    fun create(): List<Car> {
        return CarsInput().result()
    }
}