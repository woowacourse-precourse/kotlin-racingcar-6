package domain

import view.View

class CarManager {
    private var cars: MutableList<Car> = mutableListOf()
    private var tryCnt: Int = 0
    private val view = View()

    fun getNamesAndMakeCars() {
        val carNames = view.requireCarNames()
        for (name in carNames) {
            makeCar(name)
        }
    }

    fun getTryCnt() {
        tryCnt = view.requireTryCnt()
    }

    fun makeCar(name: String) {
        cars.add(Car(name))
    }

    fun confirmWinners(): MutableList<String> {
        var firstPlayers = mutableListOf<String>()
        for (car in cars) {
            if (car.getCurrentPosition() == tryCnt) {
                firstPlayers.add(car.getName())
            }
        }
        return firstPlayers
    }

    fun nextStep() {
        for (car in cars) {
            car.move()
        }
    }
}