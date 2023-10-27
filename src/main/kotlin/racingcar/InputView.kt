package racingcar

import camp.nextstep.edu.missionutils.*

class InputView {
    companion object {
        fun getNameList() : List<String> {
            println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
            val list = getInput().split(',')
            Exceptions.checkNameListInput(list)
            return list
        }

        // '.' 줄이기 위해 input함수 따로 작성
        private fun getInput() : String = Console.readLine()

        fun getRoundNumber() : Int {
            println("시도할 횟수는 몇 회인가요?")
            val number = getInput()
            Exceptions.checkNumber(number)
            return number.toInt()
        }

    }

}