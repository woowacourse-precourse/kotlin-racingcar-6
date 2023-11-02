package racingcar.util

enum class ExceptionMessage(private val message: String) {
    INVALID_LENGTH("자동차의 이름이 5보다 깁니다."),
    INVALID_UNIQUE_NAME("중복된 자동차의 이름이 존재합니다."),
    INVALID_CAR_NAME("자동차 이름에 널값이 존재합니다."),
    INVALID_INTEGER("사용자의 입력이 정수가 아닙니다."),
    INVALID_RANGE("사용자의 입력이 유효한 범위가 아닙니다.");

    fun getMessage(): String = message
}