package racingcar.view

import camp.nextstep.edu.missionutils.Console
import java.lang.NumberFormatException

class InputView {
    // 기능 1. 자동차 이름 입력받기
    fun getRacingCarName(): List<String> {
        val racingCarNameInputList = Console.readLine()
        val racingCarNameList = racingCarNameInputList.split(",")

        checkRacingCarNameValidation(racingCarNameList)

        return racingCarNameList
    }

    // 기능 2. 자동차 이름 입력 값 유효성 검사하기
    fun checkRacingCarNameValidation(checkList: List<String>) {
        val checkDuplicateList = mutableListOf<String>()

        for (check in checkList) {
            if (check.length > 5) {
                throw IllegalArgumentException("자동차 이름은 이름은 5자 이하만 가능하다.")
            }

            if (checkDuplicateList.contains(check)) {
                throw IllegalArgumentException("자동차 이름은 중복이 허용되지 않는다.")
            }

            if (check.isEmpty()) {
                throw IllegalArgumentException("쉼표(,) 뒤에 자동차 이름이 입력되지 않았다.")
            }

            if (check[0] == ' ') {
                throw IllegalArgumentException("자동차 이름의 첫글자는 공백이 아니다.")
            }

            checkDuplicateList.add(check)
        }

        if (checkList.size < 2) {
            throw IllegalArgumentException("자동차 이름은 2개 이상 입력받아야 한다.")
        }
    }

    // 기능 4. 시도할 횟수 정하기
    fun getTryNumber(): Int {
        val inputTryNumber = Console.readLine()

        checkTryNumberValidation(inputTryNumber)

        return inputTryNumber.toInt()
    }

    // 기능 5. 시도할 횟수 입력값 유효성 검사하기
    fun checkTryNumberValidation(check: String) {
        try {
            val checkNumber = check.toInt()

            if (checkNumber < 1) {
                throw IllegalArgumentException("시도할 횟수는 1보다 커야한다.")
            }

        } catch (exception: NumberFormatException) {
            throw IllegalArgumentException("시도할 횟수는 숫자여야 한다.")
        }
    }
}