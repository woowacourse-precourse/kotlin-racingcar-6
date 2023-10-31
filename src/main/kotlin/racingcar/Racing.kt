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

    fun raceCar(carResult: MutableList<Int>) {
        for (i in carResult.indices) {
            if (makeRandomNumber() >= 4) {
                carResult[i]++
            }
        }
    }

    fun findWinner(carResult: MutableList<Int>): MutableList<Int> {
        val maxNumber = carResult.max()
        val maxIndexList = mutableListOf<Int>()
        for (i in carResult.indices) {
            if (carResult[i] == maxNumber) {
                maxIndexList.add(i)
            }
        }
        return maxIndexList
    }
}