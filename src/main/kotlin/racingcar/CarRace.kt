package racingcar

import java.lang.IllegalArgumentException
import camp.nextstep.edu.missionutils.Console
object CarRace {
    fun getMoveCount(): Int {
        print("시도할 횟수를 입력하세요: ")
        val moveCount = Console.readLine()?.toInt()
        if (moveCount == null || moveCount < 1) {
            throw IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.")
        }
        return moveCount
    }

    fun getCarNames(): List<String> {
        print("경주할 자동차 이름을 쉼표(,)로 구분하여 입력하세요 (각 이름은 5자 이하): ")
        val input = Console.readLine()
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("자동차 이름을 입력해야 합니다.")
        }
        val carNames = input.split(",").map { it.trim() }
        if (carNames.any { it.length > 5 }) {
            throw IllegalArgumentException("자동차 이름은 5자 이하이어야 합니다.")
        }
        return carNames
    }
}
