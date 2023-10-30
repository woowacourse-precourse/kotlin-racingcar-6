package racingcar

import racingcar.domain.CarName
import racingcar.domain.RoundNumber

fun main() {
    val carName = CarName()
    carName.requestInput()
    val getCarName = carName.getInput()
    carName.validateInput(getCarName)

    val roundNumber = RoundNumber()
    roundNumber.requestInput()
    val getRoundNumber = roundNumber.getInput()
    roundNumber.validateInput(getRoundNumber)
}
