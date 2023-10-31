package racingcar.util

object Constants {
    // TEXT
    const val TEXT_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    const val TEXT_INPUT_ROUND = "시도할 횟수는 몇 회인가요?"
    const val TEXT_PRINT_RESULT = "실행 결과"
    const val TEXT_PRINT_WINNER = "최종 우승자"

    // VALUE
    const val CAR_NAME_DELIMITER = ","

    const val MOVE_STOP = 0
    const val MOVE_FORWARD = 1

    const val MIN_ROUND_VALUE = 1
    const val MAX_ROUND_VALUE = Int.MAX_VALUE

    // EXCEPTION
    const val EXCEPTION_WRONG_LENGTH = "자동차 이름은 1자 이상 5자 이하만 가능합니다."
    const val EXCEPTION_WRONG_NUMBER = "자동차가 최소 2대 이상이어야 경주를 할 수 있습니다."
    const val EXCEPTION_DUPLICATE_CARS = "이름이 중복되는 자동차가 존재합니다."
    const val EXCEPTION_WRONG_BOUNDARY = "라운드 횟수의 범위는 $MIN_ROUND_VALUE 이상 $MAX_ROUND_VALUE 이하입니다."
}