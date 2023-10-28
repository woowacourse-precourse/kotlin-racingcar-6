package racingcar.service

import camp.nextstep.edu.missionutils.Console.*
import racingcar.exception.Exception

class Input(private val exception: Exception) {

    fun inputName(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val name = readLine()

        with(exception) {
            checkEmpty(name)
            checkDuplicationName(name)
            checkSpaceName(name)
            checkSpaceInName(name)
            checkLengthName(name)
        }

        return name.split(",")
    }

    fun inputCycle(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val cycle = readLine()

        with(exception) {
            checkEmpty(cycle)
            checkCycleString(cycle)
        }

        return cycle.toInt()
    }
}