package racingcar

import camp.nextstep.edu.missionutils.Console

class InputManager {
    // 경주 자동차 이름 입력
    private fun inputRacingCarName(): String {
        return Console.readLine()
    }

    // 경주 시도 횟수 입력
    private fun inputTrial(): String {
        return Console.readLine()
    }

    // 입력된 경주 자동차 이름을 기반으로 경주 자동차 이름 리스트 반환
    fun getRacingCarNameList(): List<String> {
        return inputRacingCarName().split(",")
    }

    // 입력된 경주 시도 횟수를 정수형으로 반환
    fun getTrial(): Int {
        return inputTrial().toInt()
    }
}