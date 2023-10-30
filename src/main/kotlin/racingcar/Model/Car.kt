package racingcar.Domain

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

data class Car(val name: String, var distance: Int = 0) { // 각각의 자동차의 상태, 행동을 정의.

    fun carMove() {
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        if(randomNumber >= 4) {
            distance++
        }
    }

    fun getDistance(): Int {
        return distance
    }
}