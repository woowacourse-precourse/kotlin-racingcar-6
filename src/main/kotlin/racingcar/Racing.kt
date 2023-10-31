package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Racing {

    fun startRace() {
        val carList = makeCar()
        val attempt = Input().inputAttempt()
        val carResult = MutableList(carList.size) { "" }
        printStart()
        for (i in 0 until attempt) {
            race(carList, carResult)
        }
        printResult(carList, carResult)
    }

    fun race(carList: List<String>, carResult: MutableList<String>) {
        raceCar(carResult)
        printRace(carList, carResult)
    }
    fun makeCar(): List<String> {
        val inputString = Input().inputCar()
        val delim = ","
        val carList = inputString.split(delim)
        Validation().validCar(carList)
        return carList
    }

    fun makeRandomNumber(): Int {
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        return randomNumber
    }

    fun raceCar(carResult: MutableList<String>) {
        for (i in carResult.indices) {
            if (makeRandomNumber() >= 4) {
                carResult[i] += "-"
            }
        }
    }

    fun findWinner(carResult: MutableList<String>): MutableList<Int> {
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

    fun printRace(carList: List<String>, carResult: MutableList<String>) {
        for (i in carList.indices) {
            println("${carList[i]} : ${carResult[i]}")
        }
        println()
    }

    fun printResult(carList: List<String>, carResult: MutableList<String>) {
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

    fun printStart() {
        println()
        println("실행 결과")
    }
}