package domain

class CarManager {
    private var cars: MutableList<Car> = mutableListOf()
    private var tryCnt: Int = 0

    fun getNamesAndMakeCars(carNames: List<String>) {
        for (name in carNames) {
            makeCar(name)
        }
    }

    fun getTryCnt(cnt: Int) {
        tryCnt = cnt
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

    fun getCars(): MutableList<Car> {
        return this.cars
    }

    fun nextStep() {
        for (car in cars) {
            car.move()
        }
    }
}