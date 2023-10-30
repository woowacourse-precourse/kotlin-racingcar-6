package racingcar.model

import racingcar.constants.*
import racingcar.util.isDigit
import racingcar.util.isGreater

class Try private constructor(private val count: Int) {
    fun iterableTry() = 0 until count

    companion object {
        private const val MIN = 1
        private const val MAX = Int.MAX_VALUE

        fun of(countString: String): Try {
            validateTry(countString)
            return Try(countString.toInt())
        }

        private fun validateTry(countString: String) =
            with(countString) {
                validateTryEmpty(this)
                validateTryDigit(this)
                validateTryMax(this)
                validateTryMin(this.toInt())
            }

        fun validateTryEmpty(countString: String) =
            require(countString.isNotEmpty()) { TryException.EMPTY }

        fun validateTryDigit(countString: String) =
            require(countString.isDigit()) { TryException.DIGIT }

        fun validateTryMax(countString: String) =
            require(countString.isGreater(MAX.toString())) { TryException.MAX }

        fun validateTryMin(count: Int) =
            require(count >= MIN) { TryException.MIN }
    }
}