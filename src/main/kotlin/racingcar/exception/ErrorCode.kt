package racingcar.exception

enum class ErrorCode(val message: String) {
	CHARACTERS_NUMBER_EXCEEDED("5글자 이하의 이름만 가능합니다."),
	NOT_NUMBER("숫자만 입력해 주세요.")
}