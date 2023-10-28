package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.common.ExceptionConst
import racingcar.common.GameConst
import racingcar.model.Car

val carNames = mutableListOf<String>()
val cars = mutableListOf<Car>()
val tryCnt: String by lazy { Console.readLine() }
var validatedTryCnt: Int? = null

fun main() {
    enterCarName()
    validateCarNames()
    enterTryCnt()
    validateTryCnt()
    makeCar()
    doGame()
    showWinner()
}

fun enterCarName() {
    println(GameConst.ENTER_CAR_NAME_MSG)
    carNames.addAll(Console.readLine().split(",").map { it.trim() })
}

fun validateCarNames() {
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
    validatedTryCnt?.let {
        validateTryCntIsMoreThanZero()
    }
}

fun validateTryCntIsNumber() {
    tryCnt.toIntOrNull()?.let {
        validatedTryCnt = it
        return
    }
    throw IllegalArgumentException(ExceptionConst.EXCEPTION_TRY_CNT_NOT_INT)
}

fun validateTryCntIsMoreThanZero() {
    if (validatedTryCnt!!.toInt() < 1) {
        validatedTryCnt = null
        throw IllegalArgumentException(ExceptionConst.EXCEPTION_TRY_CNT_LESS_THAN_ONE)
    }
}

fun makeCar() {
    cars.addAll(
        carNames.map { name ->
            Car(_name = name)
        }
    )
}

fun enterTryCnt() {
    println(GameConst.ENTER_TRY_CNT_MSG)
    tryCnt
}

fun doGame() {
    if (validatedTryCnt == null) return
    println()
    println(GameConst.GAME_RESULT_MSG)
    var currentGameTryCnt = 0
    while (currentGameTryCnt < validatedTryCnt!!) {
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