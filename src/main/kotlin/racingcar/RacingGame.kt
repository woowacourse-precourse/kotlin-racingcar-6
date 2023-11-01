package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class RacingGame {
    fun start() {
        print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분): ")
        val carNames = readCarNames()
        print("시도할 횟수는 몇 회인가요?: ")
        val numberOfTries = readNumberOfTries()

        val cars = carNames.map { Car(it) }


    }

    private fun readCarNames(): List<String> {
        val input = Console.readLine()
        val carNames = input.split(",").map { it.trim() }
        if (carNames.any { it.length > 5 }) {
            throw IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.")
        }
        return carNames
    }

    private fun readNumberOfTries(): Int {
        val input = Console.readLine()
        return try {
            input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("올바른 숫자를 입력하세요.")
        }
    }
}
