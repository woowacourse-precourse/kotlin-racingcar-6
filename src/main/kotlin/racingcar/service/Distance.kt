package racingcar.service

import camp.nextstep.edu.missionutils.Randoms
import racingcar.domain.Car

class Distance {
    fun decideDistance(player: Car): Int {
        return if (Randoms.pickNumberInRange(0, 9) > 3) {
            player.moveForward()
        } else {
            player.stop()
        }
    }

    fun saveDistance(move: Int, distance: MutableList<String>, index: Int) {
        when (move) {
            GO -> distance[index] += GO_STRING
            STOP -> distance[index] += STOP_STRING
        }
    }

    companion object {
        private const val GO = 1
        private const val STOP = 0
        private const val GO_STRING = "-"
        private const val STOP_STRING = ""
    }
}