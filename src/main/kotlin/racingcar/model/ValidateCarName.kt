package racingcar.model

class ValidateCarName {

    companion object {
        const val MAX_CAR_NAME_COUNT = 5
        const val MAX_CAR_COUNT = 7
    }

    private val multiRacingGame = MultiRacingGame()

    fun validateInputBlank(inputCarName: String) {
        if (inputCarName.isBlank()) {
            throw IllegalArgumentException() // 여기에 NO_CAR_NAM
        }
    }

    fun validateInputMultiCarName(multiCarName: List<String?>) {
        when (false) {
            validateMaxInput5(multiCarName) -> throw IllegalArgumentException() // CAR_NAME_CO

            validateIsBlank(multiCarName) -> throw IllegalArgumentException() // NO_ALL_CAR

            validateDuplicateCarName(multiCarName) -> throw IllegalArgumentException() // DUPLICATE

            validateRacingCarRange(multiCarName) -> throw IllegalArgumentException() //CAR_COUNT_ERROR

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
