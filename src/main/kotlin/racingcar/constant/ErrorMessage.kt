package racingcar.constant

enum class ErrorMessage(val message: String) {
    NOT_NUMBER("시도 횟수는 숫자여야 합니다!"),
    NOT_EMPTY_NAMES("이름을 입력하셔아합니다!"),
    NOT_CONTAINS_NUMBER_IN_NAME("이름에는 숫자가 없어야합니다!"),
    NOT_CONTAINS_BLANK_IN_NAME("이름에는 공백이 없어야합니다!"),
    NAME_LENGTH_GREATER_THAN_FIVE("이름의 길이가 5 보다 큽니다!")
}