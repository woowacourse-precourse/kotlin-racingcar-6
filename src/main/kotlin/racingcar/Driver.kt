package racingcar

import camp.nextstep.edu.missionutils.Console

class Driver {
    fun inputCarName(): List<String> {
        return (readLine() ?: throw IllegalArgumentException(ERROR_CAR_PLAY_GAME_NULL)).split(",")
    }

    fun checkCarNameExeption() {
        val carList = inputCarName()
        //자동차의 이름은 5자 이하만 가능, 자동차는 string만
        for (carName in carList) {
            if (carName.length !in 0..5) {
                throw IllegalArgumentException(ERROR_CAR_NAME_LENGTH)
            }
        }
    }

    fun inputTryGame(): Int {
        return Console.readLine().toIntOrNull() ?: throw IllegalArgumentException(ERROR_CAR_PLAY_GAME_NULL)
    }

    companion object {
        const val ERROR_CAR_NAME_LENGTH = "자동차의 이름이 5자 이하가 아닙니다."
        const val ERROR_CAR_PLAY_GAME_NULL = "null 값이 들어왔습니다."
    }
}