package racingcar.view

import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

class InputView {
    fun printStartGameMessage() = println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")

    fun inputRacingCarName() : List<String> {
        val inputRacingCarNames = Console.readLine().split(",")
        return validateNameContainsEmpty(inputRacingCarNames)
    }

    fun validateNameContainsEmpty(inputRacingCarNames: List<String>) : List<String> {
        for (name in inputRacingCarNames) {
            if(name.contains(" ")) throw IllegalArgumentException("공백이 포함되어 있습니다.")
        }
        return validateNameLength(inputRacingCarNames.distinct())
    }

    fun validateNameLength(inputRacingCarNames: List<String>) : List<String> {
        val racingCarNames = mutableListOf<String>()
        for (name in inputRacingCarNames) {
            if(name.length in 1..5) racingCarNames.add(name)
            else if(name.isEmpty()) throw throw NullPointerException("잘못 입력하셨습니다.")
            else throw IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.")
        }
        return racingCarNames
    }

    fun printAskTryNumberMessage() = println("시도할 횟수는 몇 회인가요?")

    fun inputTryNumber() : Int = validateInputTryNumber(Console.readLine())

    fun validateInputTryNumber(inputNumber: String) : Int {
        validateInputTryNumberEmpty(inputNumber)
        validateInputTryNumberZero(inputNumber)
        validateInputTryNumberString(inputNumber)
        return inputNumber.toInt()
    }

    fun validateInputTryNumberEmpty(inputNumber: String) {
        if (inputNumber.isEmpty()) throw NullPointerException("아무것도 입력하지 않으셨습니다.")
    }

    fun validateInputTryNumberZero(inputNumber: String) {
        if (inputNumber == "0") throw IllegalArgumentException("0보다 큰 수를 입력 해야 합니다.")
    }

    fun validateInputTryNumberString(inputNumber: String) {
        for (c in inputNumber.toCharArray()) {
            if (!c.isDigit()) throw IllegalArgumentException("숫자가 아닌 문자열을 입력했습니다.")
        }
    }
}