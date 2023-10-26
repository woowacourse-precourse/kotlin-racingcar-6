package racingcar.game

import camp.nextstep.edu.missionutils.Console

object UserInput {
    fun getRacingCars(): List<Car> =
        Console.readLine().split(", ").map {_name ->
            Car(_name)
        }

    fun getAttempts(): Int = Console.readLine()!!.toInt()
}