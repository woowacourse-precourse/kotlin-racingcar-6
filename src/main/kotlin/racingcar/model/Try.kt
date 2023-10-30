package racingcar.model

import racingcar.constants.*

class Try private constructor(private val count: Int) {
    fun iterableTry() = 0 until count

    companion object {
        private const val MIN_VALUE = 1
        private const val MAX_VALUE = Int.MAX_VALUE

        fun of(countString: String): Try {
            validateTry(countString)
            return Try(countString.toInt())
        }

        private fun validateTry(countString: String) {
            validateTryEmpty(countString)
            validateTryDigit(countString)
            validateTryMax(countString)
            validateTryMin(countString.toInt())
        }

        fun validateTryEmpty(countString: String) {
            require(countString.isNotEmpty()) { TryException.EMPTY }
        }

        fun validateTryDigit(countString: String) {
            require(countString.all { countChar -> countChar.isDigit() }) { TryException.DIGIT }
        }

        fun validateTryMax(countString: String) {
            with(MAX_VALUE.toString()) {
                require(this.length > countString.length || this >= countString) { TryException.MAX }
            }
        }

        fun validateTryMin(count: Int) {
            require(count >= MIN_VALUE) { TryException.MIN }
        }
    }
}