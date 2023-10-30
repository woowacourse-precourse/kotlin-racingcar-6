package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.view.Constants.COMMA_DELIMITERS

class InputView {
    internal fun splitCarNamesByComma(carNames: String): List<String> {
        if (carNames.contains(COMMA_DELIMITERS)) {
            return carNames.split(COMMA_DELIMITERS)
        }
        return listOf(carNames)
    }

    internal fun promptCarNames(): String {
        println(INPUT_CAR_NAMES)
        return Console.readLine() ?: throw IllegalArgumentException(CAR_NAMES_NOT_ENTERED)
    }

    internal fun promptRepetition(): String {
        println(INPUT_REPOTITION)
        return Console.readLine() ?: throw IllegalArgumentException(REPOTITION_NOT_ENTERED)
    }

    companion object {
        internal const val INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        internal const val CAR_NAMES_NOT_ENTERED = "자동차 이름이 입력되지 않았습니다."

        internal const val INPUT_REPOTITION = "시도할 횟수는 몇 회인가요?"
        internal const val REPOTITION_NOT_ENTERED = "시도할 횟수가 입력되지 않았습니다."
    }
}