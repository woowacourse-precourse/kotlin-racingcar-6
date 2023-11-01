package racingcar.view

object GuideView {
    private const val INPUT_CARS_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    private const val INPUT_ROUND_COUNT = "시도할 횟수는 몇 회인가요?"
    private const val EXECUTION_RESULT = "실행 결과"

    fun printInputCarsName() {
        println(INPUT_CARS_NAME)
    }

    fun printInputRoundCnt(){
        println(INPUT_ROUND_COUNT)
    }

    fun printExecutionResult(){
        println(EXECUTION_RESULT)
    }

}