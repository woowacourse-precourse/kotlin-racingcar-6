package racingcar.game

import camp.nextstep.edu.missionutils.Randoms

const val MINIMUM_GO = 4
const val START_NUM = 0
const val END_NUM = 9
class Dice {

    fun goStop(): Boolean {
        val myNum = rollTheDice()
        return myNum >= MINIMUM_GO
    }

    private fun rollTheDice(): Int {
        return Randoms.pickNumberInRange(START_NUM, END_NUM)
    }


}