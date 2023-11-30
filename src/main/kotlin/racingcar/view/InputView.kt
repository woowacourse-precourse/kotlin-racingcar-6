package racingcar.view

import camp.nextstep.edu.missionutils.Console.readLine

class InputView {
    fun readCars(): String {
        println(INPUT_CARS_GUIDE_MESSAGE)
        return readLine()
    }

    fun readTryCount(): Int {
        println(INPUT_TRY_COUNT_GUIDE)
        return readLine().toIntOrNull() ?: -1
    }

    companion object {
        const val INPUT_CARS_GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val INPUT_TRY_COUNT_GUIDE = "시도할 횟수는 몇 회인가요?"
    }
}