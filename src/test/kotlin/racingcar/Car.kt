package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car {
    private val advanceNum = mutableListOf<Int>()

    fun generatorRandomNum(carCount: Int) {
        while (advanceNum.size < carCount) {
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            if (!advanceNum.contains(randomNumber)) {
                advanceNum.add(randomNumber)
            }
        }
    }


}