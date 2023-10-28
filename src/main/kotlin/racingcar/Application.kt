package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.common.ExceptionConst
import racingcar.common.GameConst
import racingcar.model.Car

val cars = mutableListOf<Car>()
val inputTryCnt: String by lazy { Console.readLine() }
var tryCnt: Int? = null

fun main() {
    val carNames = enterCarName()
    validateCarNames(carNames)
    enterTryCnt()
    validateTryCnt()
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

fun validateTryCnt() {
    validateTryCntIsNumber()
    tryCnt?.let {
        validateTryCntIsMoreThanZero()
    }
}

fun validateTryCntIsNumber() {
    inputTryCnt.toIntOrNull()?.let {
        tryCnt = it
        return
    }
    throw IllegalArgumentException(ExceptionConst.EXCEPTION_TRY_CNT_NOT_INT)
}

fun validateTryCntIsMoreThanZero() {
    if (tryCnt!!.toInt() < 1) {
        tryCnt = null
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

fun enterTryCnt() {
    println(GameConst.ENTER_TRY_CNT_MSG)
    inputTryCnt
}

fun doGame() {
    if (tryCnt == null) return
    println()
    println(GameConst.GAME_RESULT_MSG)
    var currentGameTryCnt = 0
    while (currentGameTryCnt < tryCnt!!) {
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