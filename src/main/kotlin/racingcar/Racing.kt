package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.Racing.GameConstants.EXECUTION_RESULT
import racingcar.Racing.GameConstants.FORWARD_STEP
import racingcar.Racing.GameConstants.RESULT_PLAYER
import racingcar.Racing.GameConstants.SCORE_LIST
import viewModel.ValidInput

class Racing {
    val inputUser = InputUser()
    fun outputStartMent() {
        println(EXECUTION_RESULT)
    }

    fun generateNumber(carName: List<String>): Map<String, Int> {
        val gameInfo = mutableMapOf<String, Int>()
        for (name in carName) {
            val number = Randoms.pickNumberInRange(0, 9)
            gameInfo[name] = number
        }
        return gameInfo
    }

    fun printPerExecutionResult(gameInfo: Map<String, Int>) {
        for ((name, number) in gameInfo) {
            println("$name : ${GameConstants.BAR.repeat(number)}")
        }
        println(GameConstants.ENTER)
    }

    fun calculateScore(gameInfo: Map<String, Int>): List<String> {
        for ((name, number) in gameInfo) {
            if (number >= FORWARD_STEP) {
                SCORE_LIST.add(name)
            }
        }
        return SCORE_LIST
    }

    private fun findTopScoreList(): String {
        val elementCounts = SCORE_LIST.groupingBy { it }.eachCount()
        val maxCount = elementCounts.maxByOrNull { it.value }?.value
        val topScore = elementCounts.filter { it.value == maxCount }.keys.toList()
        return topScore.joinToString(", ")
    }

    private fun printlnResult() {
        println(RESULT_PLAYER + findTopScoreList())
    }

    fun run() {
        inputUser.printlnDefaultMent()
        val carNames = getUserInput()
        if (isValidInput(carNames)) {
            val gameCount = getGameCountFromUser()
            startGame(carNames, gameCount)
        }
        printFinalResult()
    }

    private fun getUserInput(): List<String> {
        val inputUser = InputUser()
        return inputUser.inputCarName()
    }

    private fun isValidInput(carNames: List<String>): Boolean {
        return ValidInput().validName(carNames)
    }

    private fun getGameCountFromUser(): Int {
        val inputUser = InputUser()
        inputUser.printlnGameCountMent()
        return ValidInput().validInputGameCount()
    }

    private fun startGame(carNames: List<String>, gameCount: Int) {
        outputStartMent()
        SCORE_LIST.clear()
        repeat(gameCount) {
            val gameInfo = generateNumber(carNames)
            printPerExecutionResult(gameInfo)
            Racing().calculateScore(gameInfo)
        }
    }

    private fun printFinalResult() {
        printlnResult()
    }

    object GameConstants {
        const val EXECUTION_RESULT: String = "실행 결과"
        const val FORWARD_STEP: Int = 4
        const val RESULT_PLAYER: String = "최종 우승자 : "
        const val BAR: String = "-"
        const val LIMIT_LENGTH: Int = 5
        var SCORE_LIST = mutableListOf<String>()
        const val ENTER: String = "\n"
    }
}