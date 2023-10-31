package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.model.CarName
import racingcar.model.Round

class InputView {
    fun inputCarName(): List<CarName> {
        val cars = Console.readLine().split(",").map { name -> CarName(name) }
        return cars
    }

    fun inputRound(): Round {
        val round = Round(Console.readLine().toInt())
        return round
    }


}