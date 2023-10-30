package racingcar

class CarValidation {
    fun checkNameInputValidation(input: List<String>) {
        isInputWithinFiveChar(input)
    }

    private fun isInputWithinFiveChar(list: List<String>) {
        require(list.any { it.length > 5 }) { "자동차 이름은 5자 이하만 입력 가능합니다." }
    }




}