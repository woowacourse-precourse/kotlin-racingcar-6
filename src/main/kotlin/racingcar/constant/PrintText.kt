package racingcar.constant

enum class PrintText(val text: String) {
    REQUIRE_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    REQUIRE_ATTEMPT_COUNT("시도할 횟수는 몇 회인가요?"),
    SEPARATE_CAR_NAME_AND_FORWARD_COUNT(" : "),
    PRINT_FORWARD_MARK("-"),
    PRINT_WINNER("최종 우승자 : ")
}