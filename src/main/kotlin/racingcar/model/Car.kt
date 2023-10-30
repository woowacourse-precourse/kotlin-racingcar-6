package racingcar.model

import racingcar.constants.CarException
import racingcar.constants.Delimiter

class Car private constructor(private val name: String) : Comparable<Car> {
    private val racingResult = StringBuilder()
    private var forwardCount = 0

    fun moveForward() {
        racingResult.append(FORWARD_CHARACTER)
        forwardCount++
    }

    // name : result
    fun getRacingResultString() = "$name${Delimiter.RESULT}$racingResult"

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
        const val FORWARD_CHARACTER = '-'

        fun of(name: String): Car {
            validateName(name)
            return Car(name)
        }

        private fun validateName(name: String) {
            validateNameLength(name)
            validateNameLetter(name)
        }

        fun validateNameLength(name: String) {
            require(name.length in 1..5) { CarException.LENGTH }
        }

        fun validateNameLetter(name: String) {
            require(name.all { it.isLetter() }) { CarException.LETTER }
        }
    }
}