package racingcar

fun main() {
    val carRacingGame = CarRacingGame()
    carRacingGame.gameStart()
}

// static 문자열 리소스
const val INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
const val INPUT_TRIAL_NUMBER_MESSAGE = "시도할 횟수는 몇 회인가요?"
const val INITIAL_CAR_MOVEMENT_COUNT = 0
const val RACING_START_MESSAGE = "실행 결과"
const val PRINT_RACING_RESULT_MESSAGE = "최종 우승자 : "

