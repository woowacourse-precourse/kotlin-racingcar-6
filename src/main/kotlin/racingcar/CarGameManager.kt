package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import racingcar.Constants.Companion.EXECUTION_RESULT_MESSAGE
import racingcar.Constants.Companion.FORWARD_CONDITION
import racingcar.Constants.Companion.INPUT_PROMPT_MESSAGE
import racingcar.Constants.Companion.MAX_NUMBER
import racingcar.Constants.Companion.MIN_NUMBER
import racingcar.Constants.Companion.TRY_COUNT_PROMPT_MESSAGE

class CarGameManager {
    private val winnersList: MutableList<String> = mutableListOf()

    fun play() {
        println(INPUT_PROMPT_MESSAGE)
        val carNames = getUserInputCarData()
        val carNamesList = carNames.split(",")
        val carListCount = carNamesList.size
        Validator().validateUserInput(carNamesList.map { it.trim() })
        println(TRY_COUNT_PROMPT_MESSAGE)
        val tryCount = getUserInputCarData().toInt()
        println(EXECUTION_RESULT_MESSAGE)
        val carResultList = MutableList(carListCount){""}
        for (countTry in 0 until tryCount) {
           printExecutionResult(carResultList, carListCount, carNamesList)
        }
        findAndPrintWinners(carResultList, carListCount, carNamesList)
    }
    private fun getUserInputCarData(): String {
        return Console.readLine()
    }
    private fun generateRandomNumber(): Int {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)
    }
    private fun printExecutionResult(carResultList: MutableList<String>, carListCount: Int, carNamesList: List<String>) {
        for (countList in 0 until carListCount) {
            val randomNumber = generateRandomNumber()
            if (randomNumber >= FORWARD_CONDITION) carResultList[countList] += "-"
            println("${carNamesList[countList]} : ${carResultList[countList]}")
        }
        println()
    }
    private fun findAndPrintWinners(carResultList: MutableList<String>, carListCount: Int, carNamesList: List<String>) {
        val winnerListLength = carResultList.max().length
        for (countList in 0 until carListCount) {
            if (winnerListLength == carResultList[countList].length) {
                winnersList.add(carNamesList[countList])
            }
        }
        println("${Constants.FINAL_WINNER_MESSAGE}${winnersList.joinToString(", ")}")
    }

}