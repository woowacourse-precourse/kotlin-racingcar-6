package racingcar.Model

import racingcar.View.OutputView

open class Race(private val carNames: List<String>, val tries: Int) {
    // 게임이 시작해서 어떻게 동작하는지 작성해야 함.
    // 게임의 승자를 어떻게 고를 것인지 작성해야 함.

    private val outputView: OutputView = OutputView()
    private val cars = carNames.map { Car(it) }

    fun race() {
        repeat(tries) {
            cars.forEach { car ->
                car.moveCar()
            }
            outputView.printCarsPosition(cars)
        }
    }

    fun getWinners(): List<Car> { // 가장 멀리 이동한 자동차를 우승자로 반환하는 함수
        val maxDistance = cars.maxOf { it.fetchDistance() }
        return cars.filter {it.fetchDistance() == maxDistance }
    }
}