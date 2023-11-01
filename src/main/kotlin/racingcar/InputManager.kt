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
        return checkRacingCarNameValidation(inputRacingCarName().split(","))
    }

    // 입력된 경주 시도 횟수를 정수형으로 반환
    fun getTrial(): Int {
        return checkTrialValidation(inputTrial())
    }

    // 경주 자동차 이름 길이에 대한 유효성 검사
    private fun checkRacingCarNameValidation(racingCarNameList: List<String>): List<String> {
        for (racingCarName in racingCarNameList) {
            if (racingCarName.length >= 6) {
                throw IllegalArgumentException("이름 길이 제한 오류 발생")
            }
        }
        return racingCarNameList
    }

    // 경주 시도 횟수에 대한 유효성 검사
    private fun checkTrialValidation(trial: String): Int {
        // 사용자 입력 문자열 숫자 여부 유효성 검사
        val trialCharArray = trial.toCharArray()
        for (trialChar in trialCharArray) {
            if (trialChar.code < 48 || trialChar.code > 57) {
                print(trialChar.code)
                throw IllegalArgumentException("숫자 입력 오류 발생")
            }
        }
        return trial.toInt()
    }
}