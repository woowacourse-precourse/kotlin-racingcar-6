package racingcar

import InputUser
import camp.nextstep.edu.missionutils.Randoms

class GamePlaying {
    val input = InputUser()
    fun outputStartMent(){
        println(resultMessage.executionResult)
    }
    fun generateNumber(carName: List<String>): Map<String, Int> {
        val gameInfo = mutableMapOf<String, Int>()
        for (name in carName) {
            val numbers = Randoms.pickNumberInRange(0, 9)
            gameInfo[name] = numbers
        }
        return gameInfo
    }

    object resultMessage{
    const val executionResult: String = "실행 결과" }

}