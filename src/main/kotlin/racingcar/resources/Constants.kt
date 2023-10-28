package racingcar.resources

object Comments {
    const val ENTER_CAR_NAME_COMMENT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    const val NUMBER_OF_ATTEMPT_COMMENT = "시도할 횟수는 몇 회인가요?"
    const val GAME_RESULT_COMMENT = "실행 결과"
    const val FINAL_WINNER_COMMENT = "최종 우승자 : "
    const val SPACE = " "
    const val COMMA = ","
    const val SEPARATOR = " : "
    const val MOVEMENT = "-"
}

object Number {
    const val ZERO = 0
    const val NINE = 9
}

object GameValue {
    const val INITIAL_MOVEMENT_VALUE = 0
    const val MOVEMENT_VALUE = 1
    const val MOVEMENT_THRESHOLD_VALUE = 4
}

object ValidationValue {
    const val MIN_NAME_VALUE = 1
    const val MAX_NAME_VALUE = 5

    const val MIN_CAR_COUNT_VALUE = 1
}

object Error {
    const val ZERO_CAR_ERROR = "경주를 할 자동차가 없습니다."
    const val NAME_LENGTH_ERROR = "자동차 이름의 길이가 1 ~ 5 사이가 아닙니다."
    const val DUPLICATES_NAME_ERROR = "중복되는 자동차 이름이 존재합니다."
    const val ATTEMPT_INPUT_ERROR = "시도할 횟수가 정수가 아닙니다."
}
