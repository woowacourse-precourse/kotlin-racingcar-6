package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String, var position: Int) {

    private fun makeRandomNum(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }

    fun goOrStop() {
        val num = makeRandomNum()

        if (num >= 4) position++
    }


}