package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(name: String) {
    init {
        require(name.length <= NAME_MAX_LENGTH)
        require(name.matches(Regex(Message.NOT_ONLY_NUMBER_PATTERN)))
        require(name.isNotBlank())
    }

    var name: String = name
        private set

    var howGoForwardCount: Int = 0
        private set

    fun createMoveForwardStandard(): Boolean {
        val randomNumber = Randoms.pickNumberInRange(RANDOM_START, RANDOM_END)
        require(randomNumber in RANDOM_RANGE)

        if (randomNumber >= CAR_FORWARD_STANDARD) {
            return true
        }
        return false
    }

    fun moveForward() {
        howGoForwardCount++
    }

    companion object {
        const val NAME_MAX_LENGTH = 5
        const val CAR_FORWARD_STANDARD = 4
        val RANDOM_RANGE = 0..9
        const val RANDOM_START = 0
        const val RANDOM_END = 0
    }
}