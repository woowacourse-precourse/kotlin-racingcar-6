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
}