package racingcar

class Cars {

    private var cars = listOf<Car>()

    fun init() {
        cars = CarsBuilder().create()
    }

    fun showWinners() {
        GameWinnerGenerator(cars).result()
    }

    fun showRoundResult() {
        GameResultGenerator(cars).result()
    }
}