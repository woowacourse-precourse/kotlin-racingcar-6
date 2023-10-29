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
        if (makeRandomNumber() in 4..9)
            car.progress += 1
    }

    private fun makeRandomNumber(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }
}