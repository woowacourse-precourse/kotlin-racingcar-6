package racingcar.domain

import camp.nextstep.edu.missionutils.Console

class IOHandler(private val validator: Validator) {

    fun getCarName(): List<String> {
        val input = getInput()
        val names = splitNameFromInput(input)

        for (name in names) {
            require(validator.checkCarNameValid(name)) {
                NAME_LENGTH_IS_NOT_MATCHED
            }
        }

        return names
    }

    private fun getInput(): String = Console.readLine()

    private fun splitNameFromInput(input: String): List<String> = input.split(INPUT_SPLITTER)

    companion object {
        private const val INPUT_SPLITTER = ","
        private const val NAME_LENGTH_IS_NOT_MATCHED = "문자열 길이가 1 ~ 5에 속하지 않습니다."
    }

}
