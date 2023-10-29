package racingcar.model

class Cars() {
    private var cars: MutableList<Car> = mutableListOf()

    fun add(car: Car) {
        cars.add(car)
    }
}