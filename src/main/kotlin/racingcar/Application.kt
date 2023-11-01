package racingcar

import domain.Car
import domain.CarRacing
import domain.Constant
import domain.Constant.INPUT_CAR_NAME_TEXT
import domain.Input

fun main() {
    val carRacing = CarRacing()
    val input = Input()
    println(INPUT_CAR_NAME_TEXT)
    val cars = input.inputName().map { Car(it) }
    cars.forEach { car -> car.hashCode() }
    println(Constant.INPUT_TRY_NUM_TEXT)
    val racingNum = input.inputExecutionNumber()
    carRacing.startRacingPlay(cars, racingNum)
}
