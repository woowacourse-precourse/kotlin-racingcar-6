package racingcar
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

fun main() {
    val carNames = inputCarNames()
    val numberOfAttempts = inputNumberOfAttempts()

}

fun inputCarNames(): List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val input = readLine() ?: ""
    val carNames = input.split(",").map { it.trim() }

    if (carNames.any { it.length > 5 }) {
        throw IllegalArgumentException("자동차 이름은 5자 이하로 입력해야 합니다.")
    }

    return carNames
}

fun inputNumberOfAttempts(): Int {
    println("시도할 횟수는 몇 회인가요?")
    return readLine()?.toIntOrNull() ?: 0
}
