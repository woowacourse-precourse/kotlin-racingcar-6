package racingcar.domain

object Validation {

    fun checkContainComma(userInput: String) {
        if (!userInput.contains(","))
            throw IllegalArgumentException(COMMA_ERROR_MESSAGE)
    }

    fun checkNameLength(carNameList: List<String>) {
        carNameList.forEach { name ->
            if (name.length > NAME_MAX_LENGTH)
                throw IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE)
        }
    }

    private const val NAME_MAX_LENGTH = 5
    private const val COMMA_ERROR_MESSAGE = "쉼표(,)를 기준으로 구분해주세요"
    private const val NAME_LENGTH_ERROR_MESSAGE = "각 이름은 5자 이하만 가능합니다."
}