package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.exception.UserInputException

class InputView {
    companion object {
        fun inputCarName(): List<String> {
            println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
            val carName: List<String> = Console.readLine().split(",")
            UserInputException.checkCarNameLength(carName)
            return carName
        }

        fun inputNumberAttempts(): Int {
            println("시도할 횟수는 몇 회인가요?")
            val numberAttempts = Console.readLine()
            UserInputException.isNumber(numberAttempts)
            return numberAttempts.toInt()
        }
    }
}