package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(private val name: String, private var howGoForward: Int = 0) {
    init {
        require(name.length <= NAME_MAX_LENGTH)
        require(name.matches(Regex("^[A-Za-z가-힣]*\$")))
    }

    private fun createRandomNumber() = Randoms.pickNumberInRange(0, 9)

    fun getCarName() = this.name

    companion object {
        const val NAME_MAX_LENGTH = 5
    }
}