package racingcar.model

import racingcar.util.Validator.isNumberAttemptsValid

class AttemptsNumber(private val attempts: String) {

    val validAttemptsNum: Int
        get() = getValidAttemptsNum().toInt()

    private fun getValidAttemptsNum(): String {
        isNumberAttemptsValid(attempts)
        return attempts
    }

}