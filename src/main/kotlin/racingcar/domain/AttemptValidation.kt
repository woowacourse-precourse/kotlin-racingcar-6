package racingcar.domain

import racingcar.resources.Error.ATTEMPT_INPUT_ERROR

fun String.attemptValidation() {
    require(this.toIntOrNull() != null) {
        ATTEMPT_INPUT_ERROR
    }
}