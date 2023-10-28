package racingcar

import InputUser

fun main() {
    // TODO: 프로그램 구현
    val inputUser = InputUser()
    inputUser.printlnMent()
    val gamePlaying=GamePlaying()
    val carNames = inputUser.inputCarName()
    if(inputUser.validName(carNames)){
        inputUser.tryGameCount()
        gamePlaying.outputStartMent()
    }
}
