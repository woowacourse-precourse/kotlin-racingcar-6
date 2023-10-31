package racingcar.View

import camp.nextstep.edu.missionutils.*
import racingcar.Utils.Constans.CAR_NAME_INPUT_MENTION
import racingcar.Utils.Constans.TIME_INPUT_MENTION
import racingcar.Utils.Exceptions

class InputView {
    companion object {
        fun inputCarName(): List<String> {
            println(CAR_NAME_INPUT_MENTION)
            val carNameList = getInput().split(",")

            return checkCarNameList(carNameList)
        }
        private fun checkCarNameList(carNameList: List<String>): List<String> {
            val result = mutableListOf<String>()

            if (carNameList.isEmpty()) {
                throw IllegalArgumentException("이름을 입력해야합니다.")
            }

            for (carName in carNameList) {
                if (carName.length > 5) {
                    throw IllegalArgumentException("이름은 5글자 이하로만 가능합니다.")
                }

                if (carName.isEmpty()) {
                    throw IllegalArgumentException("이름이 제대로 입력되지 않았습니다.")
                }

                if (carName[0] == ' ') {
                    throw IllegalArgumentException("이름의 첫글자가 공백입니다.")
                }

                result.add(carName)
            }

            return result
        }
        /*
        fun getNameList(nameInput : String): List<String> {
            val list = nameInput.split(',')
            Exceptions.checkNameListInput(list)
            return list
        }

        fun getNameInput() : String {
            println(CAR_NAME_INPUT_MENTION)
            val res = getInput()
            require(res != null) { "이름 입력이 없습니다."}
            return res
        }
        */
        // '.' 줄이기 위해 input함수 따로 작성
        private fun getInput(): String {
            return Console.readLine()
        }

        fun consoleClose() {
            Console.close()
        }

        fun getRoundNumber(): Long {
            println(TIME_INPUT_MENTION)
            val number = getInput()
            Exceptions.checkNumber(number)
            return number.toLong()
        }
    }
}