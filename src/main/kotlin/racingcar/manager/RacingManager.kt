package racingcar.manager

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.Car

// 레이싱을 진행하는 매니저입니다.
class RacingManager {

    fun oneRacingCycle(
        carList: MutableList<Car>
    ) {
        for (car in carList)
            remoteCarProgress(
                car, makeRandomNumber()
            )
    }

    private fun makeRandomNumber(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }

    private fun remoteCarProgress(
        car: Car,
        randomNumber: Int
    ) {
        if (randomNumber in 4..9)
            car.progress += 1
    }
}