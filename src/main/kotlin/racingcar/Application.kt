package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.common.ExceptionConst
import racingcar.common.GameConst
import racingcar.model.Car

val cars = mutableListOf<Car>()
var validatedTryCnt: Int = 0

fun main() {
    val carNames = enterCarName()
    validateCarNames(carNames)
    val tryCnt = enterTryCnt()
    validateTryCnt(tryCnt)
    makeCar(carNames)
    doGame()
    showWinner()
}

fun enterCarName(): List<String> {
    println(GameConst.ENTER_CAR_NAME_MSG)
    return Console.readLine().split(",").map { it.trim() }
}

fun validateCarNames(carNames: List<String>) {
    validateCarNameLength(carNames)
    validateCarNameDistinct(carNames)
}

fun validateCarNameLength(carNames: List<String>) {
    carNames.forEach { name ->
        if ((name.length in 1..5).not()) throw IllegalArgumentException(ExceptionConst.EXCEPTION_CAR_NAME_LENGTH_INVALIDATE)
    }
}

fun validateCarNameDistinct(carNames: List<String>) {
    if (carNames.distinct().size != carNames.size) throw IllegalArgumentException(ExceptionConst.EXCEPTION_CAR_NAME_DUPLICATED)
}

fun validateTryCnt(tryCnt: String) {
    validateTryCntIsNumber(tryCnt)
    validateTryCntIsMoreThanZero()
}

fun validateTryCntIsNumber(tryCnt: String) {
    tryCnt.toIntOrNull()?.let {
        validatedTryCnt = it
        return
    }
    throw IllegalArgumentException(ExceptionConst.EXCEPTION_TRY_CNT_NOT_INT)
}

fun validateTryCntIsMoreThanZero() {
    if (validatedTryCnt < 1) {
        validatedTryCnt = 0
        throw IllegalArgumentException(ExceptionConst.EXCEPTION_TRY_CNT_LESS_THAN_ONE)
    }
}

fun makeCar(carNames: List<String>) {
    cars.addAll(
        carNames.map { name ->
            Car(_name = name)
        }
    )
}

fun enterTryCnt(): String {
    println(GameConst.ENTER_TRY_CNT_MSG)
    return Console.readLine()
}

fun doGame() {
    println()
    println(GameConst.GAME_RESULT_MSG)
    var currentGameTryCnt = 0
    while (currentGameTryCnt < validatedTryCnt) {
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