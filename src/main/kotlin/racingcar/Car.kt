package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(private var name: String) {
    private var position = 0
    private var result: Result = Result()

    companion object {
        const val MIN_RANDOM_NUMBER = 0
        const val MAX_RANDOM_NUMBER = 9
        const val MOVE_THRESHOLD = 4
    }

    fun getName(): String {
        return name
    }

    fun getPosition(): Int {
        return position
    }

    fun moveForward() {
        val randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)
        if (randomNumber >= MOVE_THRESHOLD) {
            position += 1
            result.printResult()
        }
    }

    fun movingState(): String {
        return "$name : ${result.getCurrentPosition()}"
    }
}

class Result {
    private var printPosition = ""

    fun getCurrentPosition(): String {
        return printPosition
    }

    fun printResult() {
        printPosition += "-"
    }
}