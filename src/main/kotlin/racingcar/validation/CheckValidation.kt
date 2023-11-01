package racingcar.validation

import racingcar.model.Car
import java.lang.NumberFormatException

// 입력값의 유효성을 검사하는 클래스입니다.
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
        carNameList: List<String>
    ) {
        require(
            checkDuplication(carNameList)
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
        carNameList : List<String>
    ): Boolean {
        val distinctCount = carNameList.distinct().count()
        return carNameList.size == distinctCount
    }

    companion object {
        private const val CAR_MAX_LENGTH = 5
        private const val CHECK_ENGLISH_AND_NUM = "^[a-zA-Z0-9]*\$"
        private const val CHECK_KOREAN = "^[가-힣]*\$"
    }
}