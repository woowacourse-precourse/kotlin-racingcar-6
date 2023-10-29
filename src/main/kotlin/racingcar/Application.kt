package racingcar

import racingcar.domain.CarName

fun main() {
    val carName = CarName()
    carName.requestInput()

    val getCarName = carName.getInput()
    carName.validateInput(getCarName)
}
