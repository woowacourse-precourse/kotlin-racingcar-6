package racingcar

import camp.nextstep.edu.missionutils.Randoms
import domain.Car
import domain.Constant
import domain.Constant.FORWARD_CONDITION_STANDARD
import domain.Constant.FORWARD_NOTATION
import domain.Constant.INPUT_CAR_NAME_TEXT
import domain.Constant.RESULT_TEXT
import domain.Input

fun main() {
    val input = Input()
    println(INPUT_CAR_NAME_TEXT)
    val cars = input.inputName().map { Car(it) }
    cars.forEach { car -> car.hashCode() }
    println(Constant.INPUT_TRY_NUM_TEXT)
    val racingNum = input.inputExecutionNumber()
    startRacingPlay(cars, racingNum)
}

fun startRacingPlay(cars: List<Car>, racing: Int) {
    println()
    println(RESULT_TEXT)
    for (playNum in 0..<racing) {
        racingPlay(cars)
        println()
    }
}

fun racingPlay(car: List<Car>) {
    // racing 게임 진행 내용 구현
    car.forEach { name -> moveForwardOrStop(name) }
}

fun moveForwardOrStop(name: Car) {
    val moveCount = createPlayRandomNum()
    if (moveCount >= FORWARD_CONDITION_STANDARD) {
        moveForward(name)
    } else {
        moveStop(name)
    }
}
fun createPlayRandomNum(): Int =
    Randoms.pickNumberInRange(Constant.FORWARD_CONDITION_MIN, Constant.FORWARD_CONDITION_MAX)

fun moveForward(name: Car) {
    val moveCount = name.moveForward()
    val named = name.toString()
//    move(moveCount)
    println("${named} : ${move(moveCount)}")
}

fun moveStop(name: Car) {
    val moveCount = name.moveStop()
    println("${name} : ${move(moveCount)}")
}

fun move(moveCount: Int): String = FORWARD_NOTATION.repeat(moveCount)