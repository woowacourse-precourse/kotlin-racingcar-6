package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import racingcar.Constants.EXECUTION_RESULT_MESSAGE
import racingcar.Constants.FORWARD_CONDITION
import racingcar.Constants.INPUT_PROMPT_MESSAGE
import racingcar.Constants.MAX_NUMBER
import racingcar.Constants.MIN_NUMBER
import racingcar.Constants.TRY_COUNT_PROMPT_MESSAGE


class CarGameManager {
    fun play() {
        println(INPUT_PROMPT_MESSAGE)
        val carNames = getUserInputString()
        val carNamesList = carNames.split(",")
        val carListCount = carNamesList.size
        Validator.userInputLength(carNamesList.map { it.trim() })
        Validator.userInputContainsNumber(carNamesList.map { it.trim() })
        println(TRY_COUNT_PROMPT_MESSAGE)
        val tryCount = getUserInputString()
        Validator.validateUserTryCount(tryCount)
        println(EXECUTION_RESULT_MESSAGE)
        val carResultList = MutableList(carListCount) { "" }
        for (countTry in MIN_NUMBER until tryCount.toInt()) {
            printExecutionResult(carResultList, carListCount, carNamesList)
        }
        determineWinnersAndPrint(carResultList, carListCount, carNamesList)
    }

    private fun getUserInputString(): String {
        return Console.readLine()
    }

    private fun generateRandomNumber(): Int {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)
    }

    private fun printExecutionResult(
        carResultList: MutableList<String>,
        carListCount: Int,
        carNamesList: List<String>
    ) {
        for (countList in MIN_NUMBER until carListCount) {
            val randomNumber = generateRandomNumber()
            if (randomNumber >= FORWARD_CONDITION) carResultList[countList] += "-"
            println("${carNamesList[countList]} : ${carResultList[countList]}")
        }
        println()
    }

    private fun determineWinnersAndPrint(
        carResultList: MutableList<String>,
        carListCount: Int,
        carNamesList: List<String>
    ) {
        val winnersList: MutableList<String> = mutableListOf()
        val winnerListLength = carResultList.max().length
        for (countList in MIN_NUMBER until carListCount) {
            if (winnerListLength == carResultList[countList].length) {
                winnersList.add(carNamesList[countList])
            }
        }
        println("${Constants.FINAL_WINNER_MESSAGE}${winnersList.joinToString(", ")}")
    }

}
