package racingcar.model

class ValidateCarName {

    companion object {
        const val MAX_CAR_NAME_COUNT = 5
        const val MAX_CAR_COUNT = 7
    }

    private val multiRacingGame = MultiRacingGame()

    fun validateInputBlank(inputCarName: String) {
        if (inputCarName.isBlank()) {
            throw IllegalArgumentException("자동차 이름을 반드시 입력해야 합니다.")
        }
    }

    fun validateInputMultiCarName(multiCarName: List<String?>) {
        when (false) {
            validateMaxInput5(multiCarName) -> throw IllegalArgumentException("자동차 이름은 5자 이하로만 가능합니다.")

            validateIsBlank(multiCarName) -> throw IllegalArgumentException("자동차 이름은 필수로 입력해야 합니다.")

            validateDuplicateCarName(multiCarName) -> throw IllegalArgumentException("자동차 이름은 중복하지 않아야 합니다.")

            validateRacingCarRange(multiCarName) -> throw IllegalArgumentException("게임에 참여 가능한 자동차 대수는 1대 이상 7대 이하만 가능합니다.")

            else -> multiRacingGame.inputTryCount(multiCarName)
        }
    }

    private fun validateMaxInput5(multiCarName: List<String?>): Boolean {
        for (element in multiCarName) {
            if (element == null || element.length > MAX_CAR_NAME_COUNT) {
                return false
            }
        }
        return true
    }

    private fun validateIsBlank(multiCarName: List<String?>): Boolean {
        for (element in multiCarName) {
            if (element!!.isBlank()) {
                return false
            }
        }
        return true
    }

    private fun validateDuplicateCarName(multiCarName: List<String?>): Boolean {
        return multiCarName.size == multiCarName.distinct().count()
    }

    private fun validateRacingCarRange(multiCarName: List<String?>): Boolean {
        return multiCarName.size <= MAX_CAR_COUNT
    }
}
