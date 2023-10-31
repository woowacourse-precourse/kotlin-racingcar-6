package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Racing {
    fun outputStartMent(){
        println(game.executionResult)
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
                println("$name : ${"-".repeat(number)}")
            }
            println("\n")
        }
    fun calculateScore(gameInfo:Map<String,Int>):List<Pair<String,Int>>{
        var scoreList= mutableListOf<Pair<String,Int>>()
        for((name,number)in gameInfo){
            if(number>=game.forwardStep){
                val score = gameInfo.count { it.value >= number }
                scoreList.add(Pair(name, score))
            }
        }
        return scoreList
    }
    fun findTopScoreList(scoreList: List<Pair<String, Int>>): List<String> {
        val maxScore = scoreList.maxBy { it.second }?.second
        return scoreList.filter { it.second == maxScore }.map { it.first }
    }
    fun printlnTopScore(topScore:List<String>){
        val topScoreMessage =game.resultPlayer+topScore.joinToString(", ")
        println(topScoreMessage)
    }
    object game{
    const val executionResult: String = "실행 결과"
    const val forwardStep:Int=4
    const val resultPlayer:String="최종 우승자 : "}

}