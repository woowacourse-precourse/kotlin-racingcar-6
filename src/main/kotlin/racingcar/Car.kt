package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car {

    private fun findForwardCondition(): Boolean {
        return Randoms.pickNumberInRange(0, 9) > 3
    }

}