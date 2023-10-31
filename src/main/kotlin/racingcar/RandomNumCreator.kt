package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RandomNumCreator {
    private val inputManager = InputManager()

    fun creator(): Int {

        return Randoms.pickNumberInRange(0, 9)
    }
}