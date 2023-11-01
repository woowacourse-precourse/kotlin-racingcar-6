package racingcar.domain

object Validation {

    private const val NAME_MAX_LENGTH = 5

    fun checkContainComma(userInput: String) {
        if (!userInput.contains(","))
            throw IllegalArgumentException("쉼표(,)를 기준으로 구분해주세요")
    }

    fun checkNameLength(carNameList: List<String>) {
        carNameList.forEach { name ->
            if (name.length > NAME_MAX_LENGTH)
                throw IllegalArgumentException("각 이름은 5자 이하만 가능합니다.")
        }
    }
}