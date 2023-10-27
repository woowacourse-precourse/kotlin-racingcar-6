package racingcar

import InputUser

fun main() {
    // TODO: 프로그램 구현
    val inputUser = InputUser()
    inputUser.printlnMent()
    val carNames = inputUser.inputCarName()
    inputUser.validName(carNames)
    val tryCount = inputUser.tryGameCount()
}
