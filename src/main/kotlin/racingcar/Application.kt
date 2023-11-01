package racingcar

import racingcar.service.CarPlayGameImpl
import racingcar.service.CarPrintGame

fun main() {
    val playGame = CarPlayGameImpl(CarPrintGame())

    playGame.playGame()
}
