package racingcar.constants

enum class Output(private val phrases: String) {
    CAR_INPUT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TRY_INPUT("시도할 횟수는 몇 회인가요?"),
    RESULT("실행 결과"),
    WINNER("최종 우승자 : ");

    override fun toString() = phrases
}