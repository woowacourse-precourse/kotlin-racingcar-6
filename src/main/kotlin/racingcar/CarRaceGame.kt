package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.CarInitializer.Companion.initializeCars
import racingcar.CarMover.Companion.move
import racingcar.CarResultPrinter.Companion.printResult

class CarRaceGame {
    companion object {
        const val CAR_NAME_LENGTH = 5
    }

    fun run() {
        val carName = getCarNames()
        val tryNumber = getTryNumbers()
        val cars = initializeCars(carName)

        repeat (tryNumber) {
            move(cars)
        }
        printResult(cars)
    }

    private fun getCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val carName = Console.readLine() ?: ""
        val cars = carName.split(",").map { it.trim() }
        val validCarNames = cars.filter { it.length <= CAR_NAME_LENGTH }
        if (validCarNames.size != cars.size) {
            throw IllegalArgumentException("자동차 이름은 5자 이하로 설정해주세요.")
        }
        return validCarNames
    }

    private fun getTryNumbers(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val tryNumber = Console.readLine()?.toInt() ?: 0
        if (tryNumber <= 0) {
            throw IllegalArgumentException("양의 정수를 입력해주세요.")
        }
        return tryNumber
    }
}