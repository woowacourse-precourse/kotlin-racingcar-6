package racingcar

import camp.nextstep.edu.missionutils.Console


const val NAME_SEPARATOR = ","
const val MAX_NAME_LENGTH = 5

class User {
    fun requestInputCarNames() {
        val input = Console.readLine()

        if (input.isEmpty()) {
            throw IllegalArgumentException("잘못 입력했어요.")
        }

        val carNames = input.split(NAME_SEPARATOR).map { it.trim() }
        carNames.forEach {
            if (it.isEmpty()) {
                throw IllegalArgumentException("자동차 이름을 잘못 입력했어요.")
            }

            if (it.length > MAX_NAME_LENGTH) {
                throw IllegalArgumentException("자동차 이름은 ${MAX_NAME_LENGTH}자 이하로 입력해주세요.")
            }
        }

        val cars = carNames.map { Car(it) }
    }
}