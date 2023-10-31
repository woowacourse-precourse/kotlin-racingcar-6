package racingcar.strings

object Strings {
    //game
    const val MESSAGE_INPUT_TRY_COUNT = "시도할 회수는 몇 회 인가요?"
    const val MESSAGE_START_GAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분) "
    const val MESSAGE_ROUND = "라운드"
    const val MESSAGE_WINNER = "최종 우승자 : "

    //exception
    const val EXCEPTION_MAX_INPUT = "자동차 이름은 5자 이하만 가능합니다."
    const val EXCEPTION_MINIMUM_SIZE = "이름은 최소 2개 이상 입력 해야 합니다."
    const val EXCEPTION_IS_BLANK = "이름을 공백으로 입력할 수 없습니다."
    const val EXCEPTION_NULL = "입력이 없습니다."
}