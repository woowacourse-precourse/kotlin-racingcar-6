package racingcar.model

import racingcar.views.OutputView

class ValidateCarName() {

    companion object {
        const val MAX_CAR_NAME_COUNT = 5
        const val MAX_CAR_COUNT = 7
    }

    fun validateInputSingleCarName(inputCarName: String): Boolean {
        when {
            validateMaxInput5(inputCarName) -> throw IllegalArgumentException(OutputView.CAR_NAME_COUNT_ERROR)
            validateInputBlank(inputCarName) -> throw IllegalArgumentException(OutputView.NO_CAR_NAME_ERROR)
        }
        return true
    }

    fun validateInputMultiCarName(multiCarName: List<String?>): Boolean {
        for (element in multiCarName) {
            when (false) {
                validateMaxInput5(element) -> throw IllegalArgumentException(OutputView.CAR_NAME_COUNT_ERROR)

                validateIsBlank(element) -> throw IllegalArgumentException(OutputView.NO_ALL_CAR_NAME_ERROR)

                validateDuplicateCarName(multiCarName) -> throw IllegalArgumentException(OutputView.DUPLICATE_CAR_NAME_ERROR)

                validateRacingCarRange(multiCarName) -> throw IllegalArgumentException(OutputView.CAR_COUNT_ERROR)
                else -> {}
            }
        }
        return true
    }

    private fun validateInputBlank(inputCarName: String): Boolean {
        if (inputCarName.isBlank()) {
            return false
        }
        return true
    }

    private fun validateMaxInput5(inputCarName: String?): Boolean {
        if (inputCarName == null || inputCarName.length > MAX_CAR_NAME_COUNT) {
            return false
        }
        return true
    }

    private fun validateIsBlank(inputCarName: String?): Boolean {
        if (inputCarName!!.isBlank()) {
            return false
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
