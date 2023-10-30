package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
fun main() {
    fun main() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val names = readCarNames()
    }

    // 사용자로부터 자동차 이름들을 입력받는 함수
    fun readCarNames(): List<String> {
        val names = Console.readLine().split(",")
        validateCarNames(names)
        return names
    }

    // 자동차 이름들의 유효성 검사를 수행하는 함수
    fun validateCarNames(names: List<String>) {
        for (name in names) {
            if (name.length > 5) { // 각 이름이 5자를 초과하면 예외 발생
                throw IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.")
            }
            if (name.isBlank()) { // 빈 문자열이나 공백 문자열일 경우 예외 발생
                throw IllegalArgumentException("자동차 이름은 공백일 수 없습니다.")
            }
        }
    }
}