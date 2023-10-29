package racingcar.model.car

import camp.nextstep.edu.missionutils.Randoms

class RandomEngine : Engine {
    override fun work(): Int {
        val randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)
        return if (randomNumber >= SUCCESS_THRESHOLD) SUCCESS else FAILURE
    }

    companion object {
        private const val MIN_RANDOM_NUMBER = 0
        private const val MAX_RANDOM_NUMBER = 9

        private const val SUCCESS_THRESHOLD = 4

        private const val SUCCESS = 1
        private const val FAILURE = 0
    }
}