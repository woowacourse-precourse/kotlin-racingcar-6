package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Racing {
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
    }

    fun printResult(carList: List<String>, carResult: MutableList<String>) {
        val maxIndexList = findWinner(carResult)
        for (index in maxIndexList) {
            print(carList[index])
            if (index != maxIndexList.last()) {
                print(", ")
            }
        }
    }
}