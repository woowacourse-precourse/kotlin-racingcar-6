package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(name: String) {
    init {
        require(name.length <= NAME_MAX_LENGTH)
        require(name.matches(Regex("^[A-Za-z가-힣]*\$")))
    }

    var name: String = name
        private set

    var howGoForwardCount: Int = 0
        private set

    private fun createRandomNumber() = Randoms.pickNumberInRange(0, 9)

    fun moveForward() {
        val randomNumber = createRandomNumber()
        require(randomNumber in RANDOM_RANGE)

        if (randomNumber >= CAR_FORWARD_STANDARD) {
            howGoForwardCount++
        }
    }

    companion object {
        const val NAME_MAX_LENGTH = 5
        const val CAR_FORWARD_STANDARD = 4
        val RANDOM_RANGE = 0..9
    }
}