package racingcar.model

import racingcar.constants.EXCEPTION_INT
import racingcar.constants.EXCEPTION_RANGE

class Try private constructor(val count: Int) {

    private fun validateTry(countString: String) {
        validateTryInt(countString)
        validateTryRange(countString.toInt())
    }

    companion object {
        fun validateTryInt(countString: String) {
            require(countString.all { it.isDigit() }) { EXCEPTION_INT }
        }

        fun validateTryRange(count: Int) {
            require(count in 0..Int.MAX_VALUE) { EXCEPTION_RANGE }
        }
    }
}