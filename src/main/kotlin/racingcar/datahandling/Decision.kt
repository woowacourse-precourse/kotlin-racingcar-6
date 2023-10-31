package racingcar.datahandling

import camp.nextstep.edu.missionutils.Randoms
import racingcar.domain.Car

class Decision {
    fun decideMovement(player: Car): Int {
        return if (Randoms.pickNumberInRange(START_NUMBER, END_NUMBER) >= FORWARD_CONDITION_NUMBER) {
            player.moveForward()
        } else {
            player.stop()
        }
    }

    fun decideWinner(playerList: List<Car>, distanceList: List<String>): List<String> {
        val playerMap = Change().changePlayerListToMap(playerList, distanceList)
        val longDistance = distanceList.sorted().reversed()[0]

        return playerMap.filterValues { it == longDistance }.keys.toList()
    }

    companion object {
        private const val START_NUMBER = 0
        private const val END_NUMBER = 9
        private const val FORWARD_CONDITION_NUMBER = 4
    }
}