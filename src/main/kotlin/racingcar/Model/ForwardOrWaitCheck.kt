package racingcar.Model

import camp.nextstep.edu.missionutils.Randoms

class ForwardOrWaitCheck {

    fun oneRoundPersonalScore():Boolean {

        var randomNumbers= Randoms.pickNumberInRange(0, 9)

        return randomNumbers>=4
    }

}