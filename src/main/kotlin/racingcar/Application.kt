package racingcar

import racingcar.data.CarFactory
import racingcar.presentation.Input

fun main() {
    val playerList = Input.getPlayerList()
    val gameCount = Input.getGameCount()
    val carList = CarFactory.makeCarList(playerList, gameCount)
}
