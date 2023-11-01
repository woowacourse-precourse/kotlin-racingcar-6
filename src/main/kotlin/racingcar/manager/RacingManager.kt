package racingcar.manager

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.Car

// 레이싱을 진행하는 매니저입니다.
class RacingManager {

    fun racingCycle(
        carList: List<Car>
    ) {
        for (car in carList)
            remoteCarProgress(car)
    }

    private fun remoteCarProgress(car: Car) {
        if (makeRandomNumber() in
            MIN_PROGRESS_NUM..MAX_PROGRESS_NUM
        )
            car.progress += 1
    }

    private fun makeRandomNumber(): Int {
        return Randoms.pickNumberInRange(
            MIN_RANDOM_NUM, MAX_RANDOM_NUM
        )
    }

    companion object {
        private const val MIN_PROGRESS_NUM = 4
        private const val MAX_PROGRESS_NUM = 9
        private const val MIN_RANDOM_NUM = 0
        private const val MAX_RANDOM_NUM = 9
    }
}