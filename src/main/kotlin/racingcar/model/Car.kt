package racingcar.model

import racingcar.constants.EXCEPTION_LENGTH
import racingcar.constants.EXCEPTION_LETTER
import racingcar.constants.FORWARD_CHARACTER

class Car private constructor(val name: String) {
    val racingResult = StringBuilder()

    fun of(name: String): Car {
        validateName(name)
        return Car(name)
    }

    private fun validateName(name: String) {
        validateNameLength(name)
        validateNameLetter(name)
    }

    fun moveForward() = racingResult.append(FORWARD_CHARACTER)

    companion object {
        fun validateNameLength(name: String) {
            require(name.length in 1..5) { EXCEPTION_LENGTH }
        }

        fun validateNameLetter(name: String) {
            require(name.all { it.isLetter() }) { EXCEPTION_LETTER }
        }
    }
}