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
        val initCar = initializeCars(carName)

        for (move in 1..tryNumber) {
            move(initCar)
        }
        printResult(initCar)
    }

    private fun getCarNames(): List<String> {
        val carNameList: MutableList<String> = mutableListOf()

        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        return try {
            val carName = Console.readLine() ?: ""
            val cars = carName.split(",").map { it.trim() }

            for (car in cars) {
                if (car.length <= CAR_NAME_LENGTH) {
                    carNameList.add(car)
                } else {
                    throw IllegalArgumentException("자동차 이름은 5자 이하로 설정해주세요.")
                }
            }
            carNameList
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("잘못된 입력입니다 : ${e.message}")
        }
    }

    private fun getTryNumbers(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return try {
            val tryNumber = Console.readLine()?.toInt() ?: 0
            if (tryNumber <= 0) {
                throw IllegalArgumentException("양의 정수를 입력해주세요.")
            }
            tryNumber
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("잘못된 입력입니다 : ${e.message}")
        }
    }
}