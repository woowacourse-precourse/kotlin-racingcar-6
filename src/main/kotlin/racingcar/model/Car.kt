package racingcar.model

import racingcar.constants.EXCEPTION_LENGTH
import racingcar.constants.EXCEPTION_LETTER

class Car {

    companion object {
        fun validateName(name: String) {
            validateNameLength(name)
            validateNameLetter(name)
        }

        fun validateNameLength(name: String) {
            require(name.length in 1..5) { EXCEPTION_LENGTH }
        }

        fun validateNameLetter(name: String) {
            require(name.all { it.isLetter() }) { EXCEPTION_LETTER }
        }
    }
}