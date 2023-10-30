package racingcar.constants

enum class CarException(private val phrases: String) {
    LENGTH("자동차 이름은 최대 5글자입니다."),
    LETTER("자동차 이름은 대소문자의 영어로만 이루어질 수 있습니다."),
    COMMA("자동차 이름을 구분하기 위한 쉼표는 이름 사이에 하나만 입력할 수 있습니다."),
    DUPLICATION("자동차 이름은 중복되지 않아야 합니다.");

    override fun toString() = phrases
}

enum class TryException(private val phrases: String) {
    DIGIT("시도할 횟수는 숫자만 입력할 수 있습니다."),
    MAX("시도할 횟수가 너무 큽니다."),
    MIN("시도할 횟수가 너무 작습니다. 1 이상의 수를 입력해주세요.");

    override fun toString() = phrases
}