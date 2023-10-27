package racingcar.model

private const val MAX_NAME_LENGTH = 5

class CarName(
    val name: String
) {
    init {
        require(name.isNotBlank()) { "이름은 공백일 수 없습니다!" }
        require(name.length <= MAX_NAME_LENGTH) { "자동차의 이름은 5자리를 넘을 수 없습니다!" }
    }
}