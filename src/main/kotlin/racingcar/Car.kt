package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car {

    fun generatorRandomNum(): Int {
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        println("내가뽑은 랜덤 값$randomNumber")
        return randomNumber
    }

    fun checkIsGoToStop(advanceNum: Int): String {
        return when (advanceNum) {
            in 0..4 -> STOP
            else -> GO
        }
    }

    companion object {
        const val STOP = "STOP"
        const val GO = "GO"
    }

}