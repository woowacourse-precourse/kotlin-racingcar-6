package racingcar

import camp.nextstep.edu.missionutils.Console

object InputHandler {

    fun getCarName(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val inputReadLine = Console.readLine()

        if (inputReadLine.contains(" ")) {
            throw IllegalArgumentException("")
        }

        val inputSplitList = inputReadLine.split(",")
        return if (isValidCarName(inputSplitList)) inputSplitList else throw IllegalArgumentException("")
    }

    fun getAmount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val inputData = Console.readLine().toIntOrNull()
        return if (isValidAmount(inputData)) inputData!! else throw IllegalArgumentException("")
    }

    fun isValidCarName(carNames: List<String>): Boolean {
        val nameSet = mutableSetOf<String>()
        return carNames.all { name ->
            isAllLowerCase(name) && isLengthLessThanOrEqualTo5(name) && nameSet.add(name)
        }
    }


    fun isValidAmount(amount: Int?): Boolean {
        amount?.let {
            if (isPositiveNumber(it)) {
                return true
            }
        }
        return false
    }

    private fun isAllLowerCase(string: String): Boolean = string.all { it.isLowerCase() }

    private fun isLengthLessThanOrEqualTo5(string: String): Boolean = if (string.length <= 5) true else false

    private fun isPositiveNumber(int: Int): Boolean = if (int > 0) true else false

}