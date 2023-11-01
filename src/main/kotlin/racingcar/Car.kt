package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(private var name: String) {
    private var position = 0

    init {
        nameErrorCheck(name)
    }

    fun getName(): String {
        return name
    }

    fun getPositionNumber(): Int {
        return position
    }

    fun getPosition(): String {
        var positionString = ""
        for (i in 1..position) {
            positionString += '-'
        }
        return positionString
    }

    fun updatePosition(updateCheck: Boolean) {
        if (updateCheck) {
            position++
        }
    }

    fun generateRandomNumber(): Int {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)
    }

    fun judgeNumber(number: Int): Boolean {
        return number >= FORWARD_NUMBER
    }
}