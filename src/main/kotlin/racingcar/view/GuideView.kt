package racingcar.view

object GuideView {
    private const val INPUT_CARS_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    private const val INPUT_ROUND_COUNT = "시도할 횟수는 몇 회인가요?"

    fun inputCarsName() {
        println(INPUT_CARS_NAME)
    }

    fun inputRoundCnt(){
        println(INPUT_ROUND_COUNT)
    }

}