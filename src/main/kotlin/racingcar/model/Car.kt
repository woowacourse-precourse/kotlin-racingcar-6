package racingcar.model

import racingcar.constants.EXCEPTION_LENGTH
import racingcar.constants.EXCEPTION_LETTER
import racingcar.constants.FORWARD_CHARACTER

class Car private constructor(val name: String) : Comparable<Car> {
    private val racingResult = StringBuilder()
    private var forwardCount = 0

    fun moveForward() {
        racingResult.append(FORWARD_CHARACTER)
        forwardCount++
    }

    fun getRacingResultString() = "$name : $racingResult"

    override fun compareTo(other: Car): Int {
        return other.forwardCount.compareTo(this.forwardCount)
    }

    override fun equals(other: Any?): Boolean {
        return this.name == (other as Car).name
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

    override fun toString() = name

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