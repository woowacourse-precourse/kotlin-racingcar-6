package racingcar.manager

class OutputManager {
    fun racingCarNames() = println(INPUT_RACING_CAR_NAMES)
    fun attemptCount()  = println(INPUT_ATTEMPT_COUNT)
    fun racingResult() = println(RACING_RESULT)
    fun newLine() = println()


    companion object {
        private const val INPUT_RACING_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        private const val INPUT_ATTEMPT_COUNT = "시도할 횟수는 몇 회인가요?"
        private const val RACING_RESULT = "실행 결과"
    }
}