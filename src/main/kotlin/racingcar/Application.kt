package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import racingcar.controller.RacingCarController
import racingcar.model.RacingCar
import racingcar.view.InputView
import racingcar.view.OutputView
import java.lang.NumberFormatException

fun main() {
    val racingCarController = RacingCarController(InputView(), OutputView())
    racingCarController.run()
}