package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import racingcar.controllers.CarRaceController
import java.lang.IllegalArgumentException

fun main() {
    val controller = CarRaceController()
    controller.startRace()
}