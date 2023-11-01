package racingcar.model

class Cars() {
    var cars: MutableList<Car> = mutableListOf()

    fun add(car: Car) {
        cars.add(car)
    }
}