package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.common.ExceptionConst
import racingcar.common.GameConst
import racingcar.model.Car

val cars = mutableListOf<Car>()

fun main() {
    val carNames = enterCarName()
    validateCarNameLength(carNames)
    validateCarNameDistinct(carNames)
    makeCar(carNames)
    doGame(enterTryCnt())
    showWinner()
}

fun enterCarName(): List<String> {
    println(GameConst.ENTER_CAR_NAME_MSG)
    return Console.readLine().split(",").map { it.trim() }
}

fun validateCarNameLength(carNames: List<String>) {
    carNames.forEach { name ->
        if ((name.length in 1..5).not()) throw IllegalArgumentException(ExceptionConst.EXCEPTION_CAR_NAME_LENGTH_INVALIDATE)
    }
}

fun validateCarNameDistinct(carNames: List<String>) {
    if (carNames.distinct().size != carNames.size) throw IllegalArgumentException(ExceptionConst.EXCEPTION_CAR_NAME_DUPLICATED)
}

fun makeCar(carNames: List<String>) {
    cars.addAll(
        carNames.map { name ->
            Car(_name = name)
        }
    )
}

fun enterTryCnt(): Int {
    println(GameConst.ENTER_TRY_CNT_MSG)
    Console.readLine().toIntOrNull()?.let { tryCnt ->
        return tryCnt
    }
    throw IllegalArgumentException(ExceptionConst.EXCEPTION_TRY_CNT_NOT_INT)
}

fun doGame(userInputTryCnt: Int) {
    println()
    println(GameConst.GAME_RESULT_MSG)
    var currentGameTryCnt = 0
    while (currentGameTryCnt < userInputTryCnt) {
        cars.forEach { car ->
            car.moveForward()
        }
        println()
        currentGameTryCnt++
    }
}

fun showWinner() {
    cars.maxOfOrNull { it.forwardCnt }?.let { maxForwardCnt ->
        val winner = cars.filter { car ->
            car.forwardCnt == maxForwardCnt
        }.joinToString { it.name }
        println(GameConst.GAME_WINNER_MSG + winner)
    }
}