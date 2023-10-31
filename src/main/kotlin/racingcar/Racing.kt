package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.Constants.Companion.CAR_DELIMITER
import racingcar.Constants.Companion.MAX_RANDOM_NUMBER
import racingcar.Constants.Companion.MIN_RANDOM_NUMBER
import racingcar.Constants.Companion.MIN_NUMBER_TO_MOVE
import racingcar.Constants.Companion.MOVE_SIGN

class Racing {

    fun startRace() {
        val carList = makeCar()
        val attempt = Input().attemptInput()
        val carResult = MutableList(carList.size) { "" }
        printStart()
        for (i in 1..attempt) {
            race(carList, carResult)
        }
        printResult(carList, carResult)
    }

    private fun race(carList: List<String>, carResult: MutableList<String>) {
        raceCar(carResult)
        printRace(carList, carResult)
    }
    private fun makeCar(): List<String> {
        val inputString = Input().carInput()
        val carList = inputString.split(CAR_DELIMITER)
        Validation().carNameValidation(carList)
        return carList
    }

    private fun makeRandomNumber(): Int {
        val randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)
        return randomNumber
    }

    private fun raceCar(carResult: MutableList<String>) {
        for (i in carResult.indices) {
            if (makeRandomNumber() >= MIN_NUMBER_TO_MOVE) {
                carResult[i] += MOVE_SIGN
            }
        }
    }

    private fun findWinner(carResult: MutableList<String>): MutableList<Int> {
        val maxLength = carResult.max()
        if (maxLength == "") {
            return mutableListOf<Int>()
        }
        val maxIndexList = mutableListOf<Int>()
        for (i in carResult.indices) {
            if (carResult[i] == maxLength) {
                maxIndexList.add(i)
            }
        }
        return maxIndexList
    }

    private fun printRace(carList: List<String>, carResult: MutableList<String>) {
        for (i in carList.indices) {
            println("${carList[i]} : ${carResult[i]}")
        }
        println()
    }

    private fun printResult(carList: List<String>, carResult: MutableList<String>) {
        val maxIndexList = findWinner(carResult)
        if (maxIndexList.isEmpty()) {
            print("우승자가 없습니다.")
            return
        }
        print("최종 우승자 : ")
        for (index in maxIndexList) {
            print(carList[index])
            if (index != maxIndexList.last()) {
                print(", ")
            }
        }
    }

    private fun printStart() {
        println()
        println("실행 결과")
    }
}