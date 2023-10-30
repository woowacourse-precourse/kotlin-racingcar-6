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
    private fun checkIsGoToStop() {
        for (carNum in advanceNum) {
            val num = when (carNum) {
                in 0..4 -> STOP
                else -> GO
            }
        }
    }

    companion object {
        const val STOP = "STOP"
        const val GO = "GO"
    }

}