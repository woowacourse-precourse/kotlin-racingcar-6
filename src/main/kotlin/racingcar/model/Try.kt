package racingcar.model

import racingcar.constants.*

class Try private constructor(val count: Int) {

    private fun validateTry(countString: String) {
        validateTryDigit(countString)
        validateTryIntMax(countString)
        validateTryPositive(countString.toInt())
    }

    companion object {
        fun validateTryDigit(countString: String) {
            require(countString.all { it.isDigit() }) { EXCEPTION_DIGIT }
        }

        fun validateTryIntMax(countString: String) {
            with(Int.MAX_VALUE.toString()) {
                require(this.length > countString.length || this >= countString) { EXCEPTION_INT_MAX }
            }
        }

        fun validateTryPositive(count: Int) {
            require(count > 0) { EXCEPTION_POSITIVE }
        }
    }
}