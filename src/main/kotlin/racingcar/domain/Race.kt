package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class Race {
    companion object {
        const val MIN_RANDOM_NUMBER = 0
        const val MAX_RANDOM_NUMBER = 9
        const val MOVE_THRESHOLD = 4
    }

    private fun goOrStop(): Int {
        return if (Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER) >= MOVE_THRESHOLD) {
            1
        } else {
            0
        }
    }

    fun racing(racingCars: Map<String, Int>): Map<String, Int> {
        val racing = racingCars.toMutableMap()
        racing.forEach { (name, value) ->
            racing[name] = value + goOrStop()
        }
        return racing.toMap()
    }
}