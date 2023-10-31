package racingcar.model

import racingcar.constants.CarException
import racingcar.constants.Delimiter
import racingcar.util.isLetter

class Car private constructor(private val name: String) : Comparable<Car> {
    private val racingResult = StringBuilder()
    private var forwardCount = 0

    fun moveForward() {
        racingResult.append(FORWARD_CHARACTER)
        forwardCount++
    }

    // "name : racingResult"
    fun getRacingResultString() = "$name${Delimiter.RESULT}$racingResult"

    override fun compareTo(other: Car) =
        other.forwardCount.compareTo(this.forwardCount)

    override fun equals(other: Any?) = this.name == (other as Car).name

    override fun hashCode() = name.hashCode()

    override fun toString() = name

    companion object {
        private const val MAX = 5
        private const val MIN = 1
        private const val FORWARD_CHARACTER = '-'

        fun of(name: String): Car {
            validateName(name)
            return Car(name)
        }

        private fun validateName(name: String) {
            validateNameLength(name)
            validateNameLetter(name)
        }

        fun validateNameLength(name: String) =
            require(name.length in MIN..MAX) { CarException.LENGTH }

        fun validateNameLetter(name: String) =
            require(name.isLetter()) { CarException.LETTER }
    }
}