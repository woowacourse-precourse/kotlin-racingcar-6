package racingcar.View

import camp.nextstep.edu.missionutils.Console
import kotlin.text.*

// 자동차의 이름 입력할 수 있는 함수 작성
// 시도할 횟수 적을 수 있는 함수 작성

class InputView{
        private val INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        private val INPUT_TRIES = "시도할 횟수는 몇 회인가요?"

        fun getCarNames(): List<String> { // 사용자로부터 자동차 이름 입력, 리스트로 반환.
            println(INPUT_CAR_NAME)
            val carNames = Console.readLine().split(",")
            checkValidInput(carNames) // 자동차 이름 checkValidInput 조건에 맞는지 확인.
            return carNames // 리스트 반환.
        }

        fun getRaceTries(): Int { // 경주를 시도할 횟수 입력.
            println(INPUT_TRIES)
            val raceCount = Console.readLine().toInt() // 정수로 입력.
            checkValidRunTries(raceCount)
            return raceCount
        }

        fun checkValidInput(carNames: List<String>) {
            for ( name in carNames ) {
                if (name.isBlank()) { // 사용자의 입력이 null이거나 공백인 경우
                    throw IllegalArgumentException("차 이름에 입력 값이 없습니다.")
                }

                if (name.length > 5) {
                    throw IllegalArgumentException("자동차의 이름은 5자를 초과할 수 없습니다.")
                }

                if (!name.all { it.isLetter()}) { // 이름이 알파벳이 아닌 다른 문자를 포함하는 경우
                    throw IllegalArgumentException("자동차의 이름은 알파벳만 가능합니다.")
                }
            }
        }

        fun checkValidRunTries(raceCount: Int) {
            if (raceCount <= 0) {
                throw IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.")
            }
        }
}