package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.model.CarName

class ConsoleRaceView : RaceView {

    override fun displayEnterCarNames() {
        println(ENTER_CAR_NAMES)
    }

    override fun getCarNamesFromUser(): List<CarName> {
        return Console.readLine().split(",").map(::CarName)
    }

    override fun displayEnterTurnNumber() {
        println(ENTER_TURN_NUMBER)
    }

    override fun getTurnNumberFromUser(): Int {
        return Console.readLine().toInt()
    }

    companion object {
        private const val ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        private const val ENTER_TURN_NUMBER = "시도할 횟수는 몇 회인가요?"
    }
}