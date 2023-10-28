package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.car.CarName

class ConsoleRaceView : RaceView {

    override fun displayEnterCarNames() {
        println(ENTER_CAR_NAMES)
    }

    override fun getCarNamesFromUser(): List<CarName> {
        return Console.readLine().split(",").map(::CarName)
    }

    companion object {
        private const val ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    }
}