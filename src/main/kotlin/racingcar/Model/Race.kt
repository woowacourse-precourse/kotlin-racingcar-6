package racingcar.Domain

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import racingcar.Domain.Car
import racingcar.View.OutputView

class Race(private val carNames: List<String>, private val tries: Int) {

   private val cars = carNames.map {Car(it)}
    fun start() {
        repeat(tries) {
            cars.forEach { it.carMove() }
            OutputView.printCarsPosition(cars)
        }
        OutputView.printWinners(cars.filter { it.distance == cars.maxOf { car -> car.distance } })
    }

    private fun getWinners(): List<Car> {
        val maxDistance = cars.maxOf { it.getDistance() }
        return cars.filter {it.getDistance() == maxDistance }
    }
}