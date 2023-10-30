package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.constants.*
import racingcar.io.*
import racingcar.model.Car
import racingcar.model.Try
import racingcar.util.toCarList

class RacingGame {
    private lateinit var cars: List<Car>
    private lateinit var `try`: Try

    fun run() {
        cars = inputRacingCarsName().let { carNames ->
            validateCarNameComma(carNames)
            carNames.toCarList()
        }

        validateCarNameDuplication(cars)

        `try` = Try.of(inputTryCount())

        println()
        println(Output.RESULT)

        for (count in `try`.iterableTry()) {
            progressGameStep()
            printCarsResult(cars)
        }

        val winners = pickWinners(cars)
        printWinners(winners)
    }

    private fun progressGameStep() {
        cars.forEach { car ->
            val random = Randoms.pickNumberInRange(RANDOM_START_NUMBER, RANDOM_END_NUMBER)
            if (isMovingForward(random)) {
                car.moveForward()
            }
        }
    }

    fun isMovingForward(number: Int) = number >= MOVING_MORE_NUMBER

    fun pickWinners(cars: List<Car>): List<Car> {
        val winnerCar = cars.sorted()[0]
        return cars.filter { car -> winnerCar.compareTo(car) == 0 }
    }

    fun validateCarNameComma(carNames: String) {
        with(Delimiter.CAR.toString()) { // 문자열 구분자 ","
            require(!carNames.contains(this.repeat(2)) &&
                    !carNames.endsWith(this) &&
                        !carNames.startsWith(this)
            ) {
                CarException.COMMA
            }
        }
    }

    fun validateCarNameDuplication(racingCars: List<Car>) =
        require(racingCars.size == racingCars.distinct().size) { CarException.DUPLICATION }

    companion object {
        private const val RANDOM_START_NUMBER = 0
        private const val RANDOM_END_NUMBER = 9
        private const val MOVING_MORE_NUMBER = 4
    }
}