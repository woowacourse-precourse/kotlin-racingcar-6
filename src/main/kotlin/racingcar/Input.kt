package racingcar

import camp.nextstep.edu.missionutils.Console

class Input {
    fun inputCarName(): List<String> {
        val carName: List<String> = Console.readLine().split(",")
        nameCheck(carName)
        return carName
    }

    fun inputGameNumber(): Int {
        val gameNumber = Console.readLine().toInt()
        gameNumberCheck(gameNumber)
        return gameNumber
    }

    private fun nameCheck(carName: List<String>) {
        for (carName in carName) {
            if (carName.length > 5) {
                throw IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.")
            }
            if (carName.isEmpty()) {
                throw IllegalArgumentException("자동차 이름을 입력해 주세요.")
            }
        }
    }

    private fun gameNumberCheck(gameNumber: Int) {
        //if (gameNumber == null) {
        //throw IllegalArgumentException("시도할 횟수를 입력해 주세요.")
        //}
        //if (gameNumber !is Int) {
        //throw IllegalArgumentException("숫자를 입력해 주세요.")
        //}
        if (gameNumber < 1) {
            throw IllegalArgumentException("1 이상의 숫자를 입력해 주세요")
        }
    }
}