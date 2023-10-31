package racingcar.View

import camp.nextstep.edu.missionutils.*
import racingcar.Utils.Constans.CAR_NAME_INPUT_MENTION
import racingcar.Utils.Constans.TIME_INPUT_MENTION
import racingcar.Utils.Exceptions

class InputView {
    companion object {
        fun getNameList(nameInput : String): List<String> {
            val list = nameInput.split(',')
            Exceptions.checkNameListInput(list)
            return list
        }

        fun getNameInput() : String {
            println(CAR_NAME_INPUT_MENTION)
            return getInput()
        }

        // '.' 줄이기 위해 input함수 따로 작성
        private fun getInput() : String {
            val result = Console.readLine()
            return result
        }

        fun getRoundNumber(): Long {
            println(TIME_INPUT_MENTION)
            val number = getInput()
            Exceptions.checkNumber(number)
            return number.toLong()
        }
    }
}