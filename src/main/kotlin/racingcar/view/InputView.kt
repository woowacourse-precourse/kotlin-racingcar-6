package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.model.CarName

class InputView {
    fun inputCarName(): List<CarName> {
        val cars = Console.readLine().split(",").map { name -> CarName(name.trim()) }
        return cars
    }

    fun inputRound(): Int {
        val round = Console.readLine().toInt()
        return round
    }


}