package racingcar.service

import camp.nextstep.edu.missionutils.Randoms
import racingcar.domain.Car

class Racing {
    init {
        startRacing()
    }
    private fun startRacing() {
        val playerList = choicePlayer()
        val cycle = Input().inputCycle()
    }

    private fun choicePlayer(): List<Car> {
        val nameList: List<String> = Input().inputName()
        return nameList.map { name -> Car(name) }
    }

    fun decideMove(player: Car): Int {
        return if (Randoms.pickNumberInRange(0, 9) > 3) {
            player.moveForward()
        } else {
            player.stop()
        }
    }
}