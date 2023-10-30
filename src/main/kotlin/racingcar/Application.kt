package racingcar

import racingcar.model.Car
import racingcar.model.ValidateCarName
import racingcar.model.ValidateRacingCount
import racingcar.utils.RandomUtils
import racingcar.views.InputView

val inputView = InputView()
val car = Car()
val validateCarName = ValidateCarName()
val validateRacingCount = ValidateRacingCount()
val randomUtils = RandomUtils()
fun main() {
    inputView.gameStartMessage()

    car.getCarName()
}
