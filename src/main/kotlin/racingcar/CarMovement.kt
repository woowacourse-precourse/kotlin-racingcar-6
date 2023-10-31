package racingcar

import camp.nextstep.edu.missionutils.Randoms

object CarMovement {
    fun moveCars(carNames: List<String>, carPositions: IntArray) {
        for (i in 0 until carNames.size) {
            val randomValue = Randoms.pickNumberInRange(0, 9)
            if (randomValue >= 4) {
                carPositions[i]++
            }
        }
    }
}
