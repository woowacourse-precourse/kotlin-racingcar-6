package racingcar.Controller

import camp.nextstep.edu.missionutils.Randoms

class ForwardConditionController {

    fun randomNumberGenerator():Int {
        return Randoms.pickNumberInRange(0, 9)
    }

    fun numberResultJudgment(randomNumber: Int):Boolean
    {
        return randomNumber>=4
    }
}