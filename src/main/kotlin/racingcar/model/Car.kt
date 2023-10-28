package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class Car(name: String) {
    private val carName: String = name
    private var moveCount: Int = 0

    fun move() {
        val randomNumber = generateRandomNumber()
        if (randomNumber >= 4) {
            moveCount += 1
        }
    }

    private fun generateRandomNumber(): Int = Randoms.pickNumberInRange(0, 9)

}