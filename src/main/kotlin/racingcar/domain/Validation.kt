package racingcar.domain

object Validation {

    fun checkContainComma(userInput: String) {
        if (!userInput.contains(","))
            throw IllegalArgumentException("쉼표(,)를 기준으로 구분해주세요")
    }

    fun checkNameLength(carNameList: List<String>) {
        carNameList.forEach { name ->
            if (name.length > 5)
                throw IllegalArgumentException("각 이름은 5자 이하만 가능합니다.")
        }
    }
}