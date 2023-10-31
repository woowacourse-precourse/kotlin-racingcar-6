package racingcar

enum class Message(val message: String) {
    INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_GAME_ROUND("시도할 횟수는 몇 회인가요?"),

    OUTPUT_GAME_END("실행 결과"),

    VALID_INPUT_NOT_BLANK("경주할 자동차의 이름이 입력되지 않았습니다."),
    VALID_INPUT_OVER_SIZE("경주할 자동차의 수가 최대 개수인 10대를 초과하였습니다."),
    VALID_INPUT_WHITESPACE("올바르지 않은 자동차의 이름이 존재합니다."),
    VALID_INPUT_LENGTH("최대 글자수(5자)를 초과하였습니다."),
    VALID_INPUT_MIN_SIZE("경주할 자동차의 수는 2대 이상이어야 합니다."),
    VALID_INPUT_PREFIX("쉼표(,)는 가장 처음에 위치할 수 없습니다."),
    VALID_INPUT_POSTFIX("쉼표(,)는 가장 마지막에 위치할 수 없습니다."),

    VALID_ROUND_SIZE("잘못된 게임 시도 횟수입니다. 1~50 사이의 값을 입력해주세요."),
}