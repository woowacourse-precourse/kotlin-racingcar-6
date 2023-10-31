package racingcar.domain

object Constants {
    // Game
    const val INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    const val INPUT_COUNT_MESSAGE = "시도할 회수는 몇회인가요?"
    const val POSITION_SYMBOL = "-"
    const val RUN_MESSAGE = "실행 결과"
    const val NEXT_WINNER = ", "
    const val COMMA = ","
    const val WINNER_MESSAGE = "최종 우승자 : "

    //Ball Status

    // Error Messages
    const val EMPTY_INPUT_ERROR_MESSAGE = "입력값이 없습니다."
    const val LENGTH_ERROR_MESSAGE = "이름은 1자 이상 5자 이하만 가능합니다."
    const val NOT_NUMBER_ERROR_MESSAGE = "입력값이 숫자가 아닙니다."
    const val DISTINCT_ERROR_MESSAGE = "중복된 이름이 존재합니다."
    const val NEGATIVE_NUMBER_ERROR_MESSAGE = "음수는 입력할 수 없습니다."
}
