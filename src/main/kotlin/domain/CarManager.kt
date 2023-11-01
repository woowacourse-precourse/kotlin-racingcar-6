package domain

import view.View

class CarManager {
    private var cars: MutableList<Car> = mutableListOf()
    private var tryCnt: Int = 0
    private val view = View()

    fun makeCars() {
        val carNames = view.requireCarNames()
        for (name in carNames) {
            makeCar(name)
        }
    }

    fun makeCar(name: String) {
        cars.add(Car(name))
    }
}