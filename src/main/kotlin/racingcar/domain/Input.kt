package racingcar.domain

import camp.nextstep.edu.missionutils.Console

class Input {

    fun carName(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val userInput = Console.readLine()
        checkContainComma(userInput)

        val carNameList = userInput.split(",")
        checkNameLength(carNameList)

        return carNameList
    }

    private fun checkContainComma(userInput: String) {
        if (!userInput.contains(","))
            throw IllegalArgumentException("쉼표(,)를 기준으로 구분해주세요")
    }

    private fun checkNameLength(carNameList: List<String>) {
        carNameList.forEach { name ->
            if (name.length > 5)
                throw IllegalArgumentException("각 이름은 5자 이하만 가능합니다.")
        }
    }

    fun attemptNum(): Int {
        println("시도할 횟수는 몇 회인가요?")
        try {
            return Console.readLine().toInt()
        } catch (e: NumberFormatException) {
            throw java.lang.IllegalArgumentException("숫자를 입력해주세요")
        }

    }
}