package racingcar.constants

enum class GameInstruction(val message: String) {
    ENTER_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    RACING_RESULT("실행 결과"),
    ATTEMPT_COUNT("시도할 횟수는 몇 회인가요?"),
}