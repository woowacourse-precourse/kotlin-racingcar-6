package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.util.Constants.CAR_RACE_NAME

class CarRaceView {

    fun inputCarName(): List<String> {
        val cars = Console.readLine().split(",").toList()

        return cars
    }

    fun inputAttemptNumber() : String {
        val num = Console.readLine()

        return num
    }

}