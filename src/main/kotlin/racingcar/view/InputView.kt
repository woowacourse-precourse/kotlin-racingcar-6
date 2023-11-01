package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.model.Car

class InputView {

    fun inputCarList(): List<Car> {
        val carList = mutableListOf<Car>()
        val carNames = Console.readLine().split(",")
        for (carName in carNames) {
            carList.add(Car(carName, 0))
        }
        return carList.toList()
    }

    fun inputAttemptCount(): Int {
        val attemptCount = Console.readLine()
        if (attemptCount.toIntOrNull() == null){
            throw IllegalArgumentException(ERROR_ATTEMPT_COUNT)
        }
        return attemptCount.toInt()
    }

    companion object{
        const val ERROR_ATTEMPT_COUNT = "유효한 숫자가 아닙니다."
    }
}