package racingcar.model

import racingcar.constants.EXCEPTION_LENGTH
import racingcar.constants.EXCEPTION_LETTER
import racingcar.constants.FORWARD_CHARACTER

class Car private constructor(val name: String) : Comparable<Car> {
    val racingResult = StringBuilder()
    private var forwardCount = 0

    fun moveForward() {
        racingResult.append(FORWARD_CHARACTER)
        forwardCount++
    }

    override fun compareTo(other: Car): Int {
        return this.forwardCount.compareTo(other.forwardCount)
    }

    companion object {
        fun of(name: String): Car {
            validateName(name)
            return Car(name)
        }

        private fun validateName(name: String) {
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