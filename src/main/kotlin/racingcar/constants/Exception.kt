package racingcar.constants

enum class CarException(private val msg: String) {
    LENGTH("1글자에서 5글자 사이의 이름을 입력해 주세요."),
    LETTER("대소문자의 영어로만 이루어진 이름을 입력해 주세요."),
    COMMA("자동차 이름을 구분하기 위한 쉼표는 이름 사이에 하나만 입력해 주세요."),
    DUPLICATION("중복되지 않는 이름을 입력해 주세요.");

    override fun toString() = msg
}

enum class TryException(private val msg: String) {
    EMPTY("시도할 횟수를 입력해 주세요."),
    DIGIT("시도할 횟수는 숫자만 입력할 수 있습니다."),
    MAX("시도할 횟수가 너무 큽니다."),
    MIN("시도할 횟수가 너무 작습니다. 1 이상의 수를 입력해 주세요.");

    override fun toString() = msg
}