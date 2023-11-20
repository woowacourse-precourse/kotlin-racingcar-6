package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.Racing.GameConstants.resultPlayer
import racingcar.Racing.GameConstants.scoreList

class Racing {


    fun outputStartMent() {
        println(GameConstants.executionResult)
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
    fun calculateScore(gameInfo: Map<String, Int>):List<String>{
        for ((name, number) in gameInfo) {
            if (number >= GameConstants.forwardStep) {
                scoreList.add(name)
            }
        }
        return scoreList
    }

    fun findTopScoreList(): String {
        val elementCounts = scoreList.groupingBy { it }.eachCount()
        val maxCount = elementCounts.maxByOrNull { it.value }?.value
        val topScore = elementCounts.filter { it.value == maxCount }.keys.toList()
        return topScore.joinToString(", ")
    }
    fun printlnResult(){
        println(resultPlayer+findTopScoreList())
    }


    object GameConstants {
        const val executionResult: String = "실행 결과"
        const val forwardStep: Int = 4
        const val resultPlayer: String = "최종 우승자 : "
        const val BAR:String="-"
        const val limitLength=5
        var scoreList = mutableListOf<String>()
        const val ENTER:String="\n"
    }
}