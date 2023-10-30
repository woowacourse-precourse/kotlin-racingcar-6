package racingcar.domain

import camp.nextstep.edu.missionutils.Console
import racingcar.data.Car

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

    fun getMoveCount(): Int {
        val input = getInput()
        val count = changeNumStringToInt(input)

        require(validator.checkMoveCountValid(count)) {
            NOT_ALLOWED_COUNT
        }

        return count
    }

    fun showLocation(cars: List<Car>) {
        for (car in cars) {
            show(car, true)
        }
    }

    fun showWinner(winners: List<Car>) {
        val sentence = winners.joinToString(", ") {
            it.name
        }
        show("$SENTENCE_FOR_WINNER$sentence")
    }

    fun show(sentence: Any, lineBreak: Boolean = false) {
        if (lineBreak) {
            println(sentence)
            return
        }
        print(sentence)
    }

    private fun getInput(): String = Console.readLine()

    private fun splitNameFromInput(input: String): List<String> = input.split(INPUT_SPLITTER)

    private fun changeNumStringToInt(input: String): Int {
        return requireNotNull(input.toIntOrNull()) {
            INPUT_IS_NOT_NUM
        }
    }

    companion object {
        const val NAME_LENGTH_IS_NOT_MATCHED = "문자열 길이가 1 ~ 5에 속하지 않습니다."
        const val INPUT_IS_NOT_NUM = "Int로 변환하려는 입력값이 숫자가 아닙니다."
        const val NOT_ALLOWED_COUNT = "허용되지 않는 이동 횟수를 입력했습니다."
        private const val INPUT_SPLITTER = ","
        private const val SENTENCE_FOR_WINNER = "최종 우승자 : "
    }

}
