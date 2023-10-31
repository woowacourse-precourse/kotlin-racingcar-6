package racingcar

class CarNames {
    private var carNamesInput: String = ""
    private lateinit var carNames: List<String>
    fun getCarNames(input: String): List<String> {
        carNamesInput = input
        carNames = carNamesInput.split(',').map { it.trim() } // 쉼표로 나눈 후 앞뒤 공백 제거

        validateCarNames(carNames)

        return carNames
    }

    // 자동차 이름 예외 처리
    private fun validateCarNames(carNames: List<String>) {
        if (carNames.any { it.isEmpty() || it.length > 5 })
            throw IllegalArgumentException("모든 자동차 이름은 1글자 이상, 5글자 이하여야 합니다.")

        if (carNames.size != carNames.toSet().size)
            throw IllegalArgumentException("자동차 이름은 중복될 수 없습니다.")
    }
}