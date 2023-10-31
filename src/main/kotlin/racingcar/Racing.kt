package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Racing {

    fun startRace() {
        val carList = makeCar()
        val attempt = Input().attemptInput()
        val carResult = MutableList(carList.size) { "" }
        printStart()
        for (i in 0 until attempt) {
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
        val delim = ","
        val carList = inputString.split(delim)
        Validation().carNameValidation(carList)
        return carList
    }

    private fun makeRandomNumber(): Int {
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        return randomNumber
    }

    private fun raceCar(carResult: MutableList<String>) {
        for (i in carResult.indices) {
            if (makeRandomNumber() >= 4) {
                carResult[i] += "-"
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