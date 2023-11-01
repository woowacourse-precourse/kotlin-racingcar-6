package racingcar.game

import camp.nextstep.edu.missionutils.Randoms

const val MINIMUM_GO = 4

class Dice {

    fun goStop(): Boolean {
        val myNum = rollTheDice()
        return myNum >= MINIMUM_GO
    }

    private fun rollTheDice(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }


}