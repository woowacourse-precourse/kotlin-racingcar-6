package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car {

    fun generatorRandomNum(carCount: Int): MutableList<Int> {
        val advanceNum = mutableListOf<Int>()
        while (advanceNum.size < carCount) {
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            if (!advanceNum.contains(randomNumber)) {
                advanceNum.add(randomNumber)
            }
        }
        return advanceNum
    }

    fun checkIsGoToStop(advanceNum: List<Int>): List<String> {
        return advanceNum.map { carNum ->
            when (carNum) {
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