package racingcar.utils

object Constants {
    const val RANGE_START = 0
    const val RANGE_END = 9
    const val MAX_CAR_NAME_LENGTH = 5
    const val MIN_MOVEMENT_THRESHOLD = 4
    const val MINIMUM_POSITIVE_NUMBER = 1

    const val EXECUTION_RESULT_MESSAGE = "실행 결과"
    const val INITIAL_WINNER_NAME_MESSAGE = "최종 우승자 : "
    const val CAR_NAMES_INPUT_PROMPT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    const val MOVE_COUNT_INPUT_PROMPT_MESSAGE = "시도할 횟수는 몇 회인가요?"
    const val COMMA = ","

    const val NON_NUMERIC_INPUT_ERROR_MESSAGE = "숫자가 아닌 다른 형식을 입력할 수 없습니다."
    const val NAME_CONTAINS_WHITESPACE_ERROR_MESSAGE = "이름에 공백을 입력할 수 없습니다."
    const val INVALID_NAME_LENGTH_MESSAGE = "이름은 다섯 자 이하로 입력해야 합니다."
    const val DUPLICATE_NAME_INPUT_ERROR_MESSAGE = "중복된 이름을 입력할 수 없습니다."
    const val INVALID_NON_POSITIVE_NUMBER_ERROR_MESSAGE = "1 이상의 숫자만 입력할 수 있습니다."
}