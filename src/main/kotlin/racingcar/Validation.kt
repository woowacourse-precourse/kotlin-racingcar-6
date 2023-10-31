package racingcar

import racingcar.Constants.Companion.MAX_CAR_LENGTH
import racingcar.Constants.Companion.CHAR_ZERO
import racingcar.Constants.Companion.CHAR_NINE
import racingcar.Constants.Companion.MIN_NUMBER_ATTEMPT

class Validation {

    fun carNameValidation(carList: List<String>) {
        validCar(carList)
    }

    fun attemptValidation(inputInt: String) {
        validAttempt(inputInt)
    }

    private fun validCar(carList: List<String>) {
        for (car in carList) {
            require(car.isNotEmpty()) { "차 이름은 1글자 이상이어야 합니다." }
            require(car.length <= MAX_CAR_LENGTH) { " 차 이름은 5글자 이하이어야 합니다." }
        }
    }

    private fun validAttempt(inputInt: String) {
        inputInt.forEach { char ->
            val charCode = char.code
            require(charCode in CHAR_ZERO..CHAR_NINE) { " 숫자만 입력 받을 수 있습니다. "}
        }
        require(inputInt.toInt() >= MIN_NUMBER_ATTEMPT) { " 시도할 횟수는 1 이상의 수이어야 합니다. "}
    }
}