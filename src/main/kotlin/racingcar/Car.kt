package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(private var name: String) {
    private var position = 0
    private var result: Result = Result()

    fun getName(): String {
        return name
    }

    fun getPosition(): Int {
        return position
    }


    fun moveForward() {
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        if (randomNumber >= 4) {
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