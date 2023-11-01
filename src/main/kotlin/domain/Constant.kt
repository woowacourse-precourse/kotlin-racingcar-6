package domain

object Constant {
    const val INPUT_CAR_NAME_TEXT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    const val INPUT_TRY_NUM_TEXT = "시도할 횟수는 몇 회인가요?"
    const val RESULT_TEXT = "실행 결과"
    const val FINAL_WINNER = "최종 우승자 : "

    const val FORWARD_NOTATION = "-"
    const val NAME_DIVISION_NOTATION = ","

    const val FORWARD_CONDITION_MIN = 0
    const val FORWARD_CONDITION_MAX = 9
    const val FORWARD_CONDITION_STANDARD = 4
    const val CAR_NAME_MAX = 5
    const val MIN_NUM_RANGE_ASCII = 48
    const val MAX_NUM_RANGE_ASCII = 57

    const val WRONG_NAME_LENGTH_EXCEPTION = "잘못된 길이의 입력값 입니다. 5자 이하로 입력해주세요"
    const val WRONG_NOTATION_EXCEPTION = "잘못된 표기 방식입니다. 쉼표(,)를 이용해 주세요"
    const val NO_EXIST_INPUT_EXCEPTION = "입력값이 존재하지 않습니다."
    const val WRONG_NUM_EXCEPTION = "잘못된 입력 형식입니다. 숫자를 입력해주세요."
}
