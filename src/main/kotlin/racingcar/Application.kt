package racingcar

import racingcar.controller.RacingCarController
import racingcar.repository.RacingCarsRepository
import racingcar.service.RacingCarService
import racingcar.util.RandomNumberGenerator
import racingcar.view.PrintOutputView
import racingcar.view.ReadUserInputView

fun main() {
    RacingCarController(
        ReadUserInputView(),
        PrintOutputView(),
        RacingCarService(RandomNumberGenerator(), RacingCarsRepository())
    ).play()
}
