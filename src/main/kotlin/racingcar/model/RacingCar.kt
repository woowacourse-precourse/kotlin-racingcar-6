package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

data class RacingCar(val racingCarName: String, private var distance: Int) {
    fun getDistance(): Int {
        return distance
    }

    fun addRacingCarDistance() {
        val randomNum = Randoms.pickNumberInRange(RANDOM_START_NUM, RANDOM_FINISH_NUM)
        if (randomNum >= MIN_DISTANCE_NUM) {
            distance ++
        }
    }

    companion object {
        private const val RANDOM_START_NUM = 0
        private const val RANDOM_FINISH_NUM = 9

        const val MIN_DISTANCE_NUM = 4
    }
}