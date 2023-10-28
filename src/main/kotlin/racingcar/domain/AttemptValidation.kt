package racingcar.domain

import racingcar.resources.Error.ATTEMPT_INPUT_ERROR

fun String.attemptValidation() {
    let { attempt ->
        require(attempt.toIntOrNull() != null) {
            ATTEMPT_INPUT_ERROR
        }
    }
}