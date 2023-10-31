package racingcar.util

object ValidationUtil {

    fun validateCarNames(carNames: List<String>) {
        require(carNames.all { it.trim().isNotEmpty() }) { "자동차 이름은 비어 있을 수 없습니다." }
        require(carNames.all { it.length <= 5 }) { "자동차 이름은 5자 이하만 가능합니다." }
        require(carNames.toSet().size == carNames.size) { "자동차 이름은 중복될 수 없습니다." }
    }

    fun validateNumberOfRounds(userInputNumberOfRounds: String) {
        require(userInputNumberOfRounds.toIntOrNull()?.let { it > 0 } == true) {
            "시도 횟수는 자연수로 입력해주세요."
        }
    }
}