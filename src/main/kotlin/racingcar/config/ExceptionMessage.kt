package racingcar.config

import racingcar.config.GameConfig.MAX_CAR_NAME_LENGTH
import racingcar.config.GameConfig.MAX_TRY_COUNT
import racingcar.config.GameConfig.MIN_TRY_COUNT

object ExceptionMessage {
    const val INVALID_INTEGER = "유효한 정수를 입력해주세요 ($MIN_TRY_COUNT 이상, $MAX_TRY_COUNT 이하)."
    const val INVALID_CAR_NAME = "올바른 이름을 입력해주세요."
    const val TOO_LONG_NAME = "이름은 ${MAX_CAR_NAME_LENGTH}자 이하까지 입력 가능합니다."
    const val DUPLICATED_NAME = "중복된 이름이 있습니다."
}

