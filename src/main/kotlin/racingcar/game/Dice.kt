package racingcar.game

import camp.nextstep.edu.missionutils.Randoms

class Dice {

    fun goStop():Boolean {
        val myNum = rollTheDice()
        return myNum>=4
    }
    private fun rollTheDice():Int {
        return Randoms.pickNumberInRange(0, 9)
    }


}