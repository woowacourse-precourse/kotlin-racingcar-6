package racingcar.domain.car

class Cars {
    private var cars = mutableListOf<Car>()
    private var highScore: Int = 0;
    private var isFirst = true

    fun addCar(car: Car) {
        cars.add(car)
    }

    fun isEqualHighScore(num: Int): Boolean {
        if (num == highScore)
            return true
        return false
    }

    fun compareHighScore(num: Int) {
        if (num > highScore)
            highScore = num
    }

    fun getCars(): MutableList<Car> {
        return cars
    }

    fun isFirst(): Boolean {
        if (isFirst) {
            isFirst = false
            return true
        }
        return false
    }
}