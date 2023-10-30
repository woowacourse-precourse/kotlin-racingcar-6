package racingcar.model

private const val MAX_NAME_LENGTH = 5
private const val BLANK_NAME_EXCEPTION = "이름은 공백일 수 없습니다!"
private const val OVER_LENGTH_NAME_EXCEPTION = "자동차의 이름은 5자리를 넘을 수 없습니다!"
class CarName(
    val name: String
) {
    init {
        require(name.isNotBlank()) { BLANK_NAME_EXCEPTION }
        require(name.length <= MAX_NAME_LENGTH) { OVER_LENGTH_NAME_EXCEPTION }
    }
}