package racingcar.view

class Message(private val message : String) {
    override fun toString() = message
    companion object{
        const val NAME_OF_CARS = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val NUMBER_OF_ATTEMPTS = "시도할 횟수는 몇 회인가요?"
        const val RESULT_PHRASE = "\n실행 결과"
        const val RESULT_FORMAT ="%s : %s"
        const val FINAL_WINNER_FORMAT = "최종 우승자 : %s"
    }

}