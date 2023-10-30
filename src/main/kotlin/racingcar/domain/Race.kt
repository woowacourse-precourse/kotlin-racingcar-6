package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class Race {

    fun attemptNumber(): Int? {
        return null
    }

    fun racing(racingCars: Map<String, Int>): Map<String, Int> {
        val racing = racingCars.toMutableMap()
        racing.forEach { (name, value) ->
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                racing[name] = value + 1
            }
        }
        return racing.toMap()
    }
}