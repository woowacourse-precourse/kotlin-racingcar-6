package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class Race {

    fun attemptNumber(): Int? {
        return null
    }

    fun racing(racingCar: String): Boolean {
        val go: Boolean = true
        val stop: Boolean = false
        return if (Randoms.pickNumberInRange(0, 9) >= 4) go else stop
    }
}