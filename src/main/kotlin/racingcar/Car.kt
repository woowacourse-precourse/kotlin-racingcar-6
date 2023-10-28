package racingcar

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

const val FORWARDABLE_NUMBER = 4

class Car(val name: String) {

    private var forwardCount = 0

    private fun increaseForwardCount() = forwardCount++

    private fun forwardCar() {
        val randomNumber = pickNumberInRange(0, 9)

        if (randomNumber >= FORWARDABLE_NUMBER) increaseForwardCount()
    }
}