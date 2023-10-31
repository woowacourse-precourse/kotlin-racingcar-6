package constant

class Constant {
    companion object {
        const val MOVE_BASE_NUMBER = 4
        const val RANDOM_START_NUMBER = 0
        const val RANDOM_END_NUMBER = 9
        const val CAR_NAME_MIN_LENGTH = 1
        const val CAR_NAME_MAX_LENGTH = 5
        const val MAX_TRY_NUMBER = Int.MAX_VALUE
        const val MIN_TRY_NUMBER = 1

        // 출력문
        const val CAR_INPUT_STRING = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n"
        const val TRY_NUMBER_INPUT_STRING = "시도할 횟수는 몇 회인가요?\n"
        const val RESULT_STRING = "\n실행 결과"
        const val WINNER_STRING = "최종 우승자 : "
    }
}