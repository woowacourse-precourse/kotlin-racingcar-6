package racingcar

enum class Message(val message: String) {
    INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_GAME_ROUND("시도할 횟수는 몇 회인가요?"),

    OUTPUT_GAME_END("실행 결과"),

    VALID_INPUT_NOT_BLANK("경주할 자동차의 이름이 입력되지 않았습니다."),
}