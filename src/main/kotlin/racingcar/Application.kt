package racingcar

import domain.Car
import domain.Constant.RESULT_TEXT
import domain.Racing

fun main() {
    val car = Car()
    car.printName()
    val carName = car.inputName()
    println(carName)
    val racing = Racing()
    racing.printRacing()
    val racingNum = racing.inputExecutionNumber()
    startRacingPlay(carName, racingNum)
}

fun startRacingPlay(car: List<String>, racing: Int) {
    println(RESULT_TEXT)
    for (playNum in 0..<racing) {
        racingPlay()
    }
}

fun racingPlay() {
    // racing 게임 진행 내용 구현
}