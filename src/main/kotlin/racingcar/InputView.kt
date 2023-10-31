package racingcar

import camp.nextstep.edu.missionutils.Console

class InputView {
    // 기능 1. 자동차 이름 입력받기
    fun inputRacingCarName(): List<String> {
        val racingCarNameList = Console.readLine().split(",")

        return validateRacingCarName(racingCarNameList)
    }

    // 기능 2. 자동차 이름 입력 값 유효성 검사하기
    fun validateRacingCarName(racingCarNameList: List<String>): List<String> {
        val validRacingCarNameList = mutableListOf<String>()

        for (racingCarName in racingCarNameList) {
            if (racingCarName.length > 5) {
                throw IllegalArgumentException("자동차 이름은 이름은 5자 이하만 가능하다.")
            }

            if (validRacingCarNameList.contains(racingCarName)) {
                throw IllegalArgumentException("자동차 이름은 중복이 허용되지 않는다.")
            }

            if (racingCarName.isEmpty()) {
                throw IllegalArgumentException("쉼표(,) 뒤에 자동차 이름이 입력되지 않았다.")
            }

            if (racingCarName[0] == ' ') {
                throw IllegalArgumentException("자동차 이름의 첫글자는 공백이 아니다.")
            }

            validRacingCarNameList.add(racingCarName)
        }

        if (racingCarNameList.size < 2) {
            throw IllegalArgumentException("자동차 이름은 2개 이상 입력받아야 한다.")
        }

        return validRacingCarNameList
    }

    // 기능 4. 시도할 횟수 정하기
    fun inputAttemptNumber(): Int {
        val attemptNumber = Console.readLine()

        return validateAttemptNumber(attemptNumber)
    }

    // 기능 5. 시도할 횟수 입력값 유효성 검사하기
    fun validateAttemptNumber(attemptNumber: String): Int {
        try {
            val validAttemptNumber = attemptNumber.toInt()

            if (validAttemptNumber < 1) {
                throw IllegalArgumentException("시도할 횟수는 1보다 커야합니다.")
            }

            return validAttemptNumber
        } catch (exception: NumberFormatException) {
            throw IllegalArgumentException("시도할 횟수는 숫자여야 합니다.")
        }
    }
}