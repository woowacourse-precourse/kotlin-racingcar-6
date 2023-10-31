package racingcar.model

import racingcar.views.OutputView

class ValidateCarName {

    companion object {
        const val MAX_CAR_NAME_COUNT = 5
        const val MAX_CAR_COUNT = 7
    }

    private val multiRacingGame = MultiRacingGame()

    fun validateInputBlank(inputCarName: String) {
        if (inputCarName.isBlank()) {
            throw IllegalArgumentException(OutputView.NO_CAR_NAME_ERROR)
        }
    }

    fun validateInputMultiCarName(multiCarName: List<String?>) {
        when (false) {
            validateMaxInput5(multiCarName) -> throw IllegalArgumentException(OutputView.CAR_NAME_COUNT_ERROR)

            validateIsBlank(multiCarName) -> throw IllegalArgumentException(OutputView.NO_ALL_CAR_NAME_ERROR)

            validateDuplicateCarName(multiCarName) -> throw IllegalArgumentException(OutputView.DUPLICATE_CAR_NAME_ERROR)

            validateRacingCarRange(multiCarName) -> throw IllegalArgumentException(OutputView.CAR_COUNT_ERROR)

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
