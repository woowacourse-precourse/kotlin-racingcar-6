package racingcar

import camp.nextstep.edu.missionutils.Console

class CarsInput {
    fun result(): List<Car> {
        return inputCarNames().map { Car(it) }
    }

    // TODO 예외처리
    private fun inputCarNames(): List<String> {
        return Console.readLine().split(",")
    }
}