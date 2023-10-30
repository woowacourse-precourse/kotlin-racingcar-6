package racingcar

import camp.nextstep.edu.missionutils.Randoms

class MoveCars(private val nameList: List<String>, private val tryNumber: Int) {

    private val moveNumList = MutableList(nameList.size) { 0 }
    private fun randomNumber() {
        for (i in nameList.indices) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                moveNumList[i]++
            }
            println("${nameList[i]} : " + "-".repeat(moveNumList[i]))
        }
        println()
    }

    fun repeatTryNumber() {
        println("\n실행 결과")
        for (i in 0 until tryNumber) {
            randomNumber()
        }
    }


}