package racingcar

class CarsBuilder {
    fun create(): List<Car> {
        return CarsInput().result()
    }
}