package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.constants.*
import racingcar.io.inputRacingCars
import racingcar.io.inputTryCount
import racingcar.io.printCarListResult
import racingcar.io.printWinner
import racingcar.model.Car
import racingcar.model.Try
import racingcar.util.toCarList

class RacingGame {
    private lateinit var carList: List<Car>
    private lateinit var `try`: Try

    fun run() {
        carList = inputRacingCars().let { carNames ->
            validateCarNameComma(carNames)
            carNames.toCarList()
        }

        validateCarNameDuplication(carList)

        `try` = Try.of(inputTryCount())

        println()
        println("실행 결과")

        for (count in 0 until `try`.count) {
            progressGameStep()
            printCarListResult(carList)
        }

        val winnerList = pickWinner(carList)
        printWinner(winnerList)
    }

    private fun progressGameStep() {
        carList.forEach { car ->
            val random = Randoms.pickNumberInRange(RANDOM_START_NUMBER, RANDOM_END_NUMBER)
            if (isMovingForward(random)) {
                car.moveForward()
            }
        }
    }

    fun isMovingForward(number: Int): Boolean {
        return number >= MOVING_MORE_NUMBER
    }

    fun pickWinner(carList: List<Car>): List<Car> {
        val winnerForwardCount = carList.sorted()[0].forwardCount
        return carList.filter { car -> car.forwardCount == winnerForwardCount }
    }

    fun validateCarNameComma(carNames: String) {
        require(!carNames.contains(",,") && !carNames.endsWith(",") && !carNames.startsWith(",")) { EXCEPTION_COMMA }
    }

    fun validateCarNameDuplication(racingCars: List<Car>) {
        require(racingCars.size == racingCars.distinct().size) { EXCEPTION_DUPLICATION }
    }
}