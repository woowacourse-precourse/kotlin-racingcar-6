package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class RacingCarGame {
    private val carInput: String = Console.readLine()
    private val numberOfTryStr: String = Console.readLine()
    //private val readCar = ReadCar()
    //private val carInput = readCar.carInput
    //private val numberOfTryStr = readCar.numberOfTry
    private val carList: List<String> = carInput.split(',')
    private val gameProgress: MutableMap<String, String> = mutableMapOf()
    private val moveCount: MutableMap<String, Int> = mutableMapOf()


    private fun setProgress() {
        for (carName in carList) {
            gameProgress[carName] = "$carName : "
        }
    }

    private fun setMoveCount() {
        for (carName in carList) {
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

    private fun notIntException(){
        try {
            numberOfTryStr.toInt()
        } catch (ex: NumberFormatException) {
            throw IllegalArgumentException("정수만 입력")
        }
    }

    private fun printGameProgress(){
        for (carName in carList) {
            println(gameProgress[carName])
        }
    }

    private fun printWinner(){
        val moveCountList = moveCount.toList()
        val sortedMoveCountList = moveCountList.sortedWith(compareByDescending { it.second })
        print("최종 우승자 : ")
        for (i in carList.indices) {
            print(sortedMoveCountList[i].first)
            if (i == carList.size - 1) {
                break
            }
            if (sortedMoveCountList[i].second != sortedMoveCountList[i + 1].second) {
                break
            }
            print(", ")
        }
    }

    fun gameStart() {
        isNameNotExceed5Letters()
        setProgress()
        setMoveCount()
        notIntException()

        println("\n실행 결과")
        for (i in 0..<numberOfTryStr.toInt()) {
            goOrNot()
            printGameProgress()
            println()
        }
        printWinner()
    }
}
