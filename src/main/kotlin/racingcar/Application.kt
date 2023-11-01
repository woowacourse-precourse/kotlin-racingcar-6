package racingcar

import racingcar.data.CarFactory
import racingcar.presentation.Input
import racingcar.presentation.Output

fun main() {
    val playerList = Input.getPlayerList()
    val gameCount = Input.getGameCount()
    val carList = CarFactory.makeCarList(playerList, gameCount)
    Output.printResult(carList)
    Input.close()
}
