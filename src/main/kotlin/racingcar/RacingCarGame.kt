package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class RacingCarGame {
    private val carInput: String = Console.readLine()
    private val numberOfTry: Int = Console.readLine().toInt()
    private val carList: List<String> = carInput.split(',')
    private val gameProgress: MutableMap<String, String> = mutableMapOf()
    private val moveCount: MutableMap<String, Int> = mutableMapOf()

    private fun setProgress() {
        for (carName in carList) {
            gameProgress[carName] = "$carName: "
        }
    }

    private fun setMoveCount() {
        for (carName in carList){
            moveCount[carName] = 0
        }
    }

    private fun isNameNotExceed5Letters() {
        for (carName in carList) {
            if (carName.length > 5) {
                throw IllegalArgumentException("이름은 5자 이하여야 합니다.")
            }
        }
    }

    private fun go(carName: String) {
        gameProgress[carName] = gameProgress[carName] + '-'
    }

    private fun goOrNot() {
        for (carName in carList) {
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            if (randomNumber >= 4) {
                go(carName)
                moveCount[carName] = moveCount[carName]!! + 1
            }
        }
    }

    fun gameStart() {
        isNameNotExceed5Letters()
        setProgress()
        setMoveCount()

        for (i in 0..<numberOfTry) {
            goOrNot()

            for (carName in carList) {
                println(gameProgress[carName])
            }
            println()
        }

        val moveCountList = moveCount.toList()
        val sortedMoveCountList = moveCountList.sortedWith(compareByDescending { it.second })
        val sortedMoveCount = sortedMoveCountList.toMap()
        println("최종 우승자 : ")
        for (i in carList.indices){
            print(sortedMoveCountList[i].first)
            if (i == carList.size-1){
                break
            }
            if(sortedMoveCountList[i].second != sortedMoveCountList[i+1].second){
                break
            }
            print(", ")
        }
    }
}
