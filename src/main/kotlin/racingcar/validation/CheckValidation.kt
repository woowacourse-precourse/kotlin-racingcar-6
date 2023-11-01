package racingcar.validation

import racingcar.model.Car
import java.lang.NumberFormatException

class CheckValidation {

    fun checkCarLength(
        carName: String
    ) {
        require(
            checkNameLength(carName) &&
                    checkNameIsBlank(carName)
        ) {
            "자동차 이름은 1자 이상, 5자 이하만 가능합니다."
        }
    }

    fun checkCarNameValidation(
        carName: String
    ) {
        require(
            checkEnglishAndNumRegex(carName) ||
                    checkKoreanRegex(carName)
        ) {
            "올바른 자동차 이름을 입력해야 합니다."
        }
    }


    fun checkInputRacingCount(
        userInput: String
    ) {
        require(
            checkIsnumber(userInput) &&
                    checkIsPositive(userInput.toInt())
        ) {
            "양의 정수를 입력해야 합니다."
        }
    }

    fun checkDuplicateCarName(
        carList: List<Car>
    ) {
        require(
            checkDuplication(carList)
        ) {
            "자동차 이름은 중복을 허용하지 않습니다."
        }
    }

    private fun checkIsnumber(
        userInput: String
    ): Boolean {
        return try {
            userInput.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    private fun checkIsPositive(
        number: Int
    ): Boolean {
        return number > 0
    }

    private fun checkNameLength(
        carName: String
    ): Boolean {
        return carName.length <= CAR_MAX_LENGTH
    }

    private fun checkNameIsBlank(
        carName: String
    ): Boolean {
        return carName.isNotEmpty()
    }

    private fun checkEnglishAndNumRegex(
        carName: String
    ): Boolean {
        return carName.matches(CHECK_ENGLISH_AND_NUM.toRegex())
    }

    private fun checkKoreanRegex(
        carName: String
    ): Boolean {
        return carName.matches(CHECK_KOREAN.toRegex())
    }

    private fun checkDuplication(
        carList : List<Car>
    ): Boolean {
        val distinctCount = carList.distinct().count()
        return carList.size == distinctCount
    }

    companion object {
        private const val CAR_MAX_LENGTH = 5
        private const val CHECK_ENGLISH_AND_NUM = "^[a-zA-Z0-9]*\$"
        private const val CHECK_KOREAN = "^[가-힣]*\$"
    }
}