package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.Racing.GameConstants.EXECUTION_RESULT
import racingcar.Racing.GameConstants.FORWARD_STEP
import racingcar.Racing.GameConstants.RESULT_PLAYER
import racingcar.Racing.GameConstants.SCORE_LIST
import viewModel.ValidInput

class Racing {
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

    fun printlnResult() {
        println(RESULT_PLAYER + findTopScoreList())
    }

    fun run() {
        val inputUser = InputUser()
        val carNames = inputUser.inputCarName()

        if (ValidInput().validName(carNames)) {
            inputUser.printlnGameCountMent()
            val gameCount = ValidInput().validInputGameCount()
            outputStartMent()
            SCORE_LIST.clear()
            for (round in 1..gameCount) {
                var gameInfo = generateNumber(carNames)
                printPerExecutionResult(gameInfo)
                Racing().calculateScore(gameInfo)
            }
        }
        Racing().printlnResult()
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