package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputTry {
    operator fun invoke(tryCount: String = Console.readLine()): Int {
        val count = tryCount.toIntOrNull()
        return when {
            count == null || count <= 0 -> {
                throw IllegalArgumentException("${Integer.MAX_VALUE} 이하의 자연수를 입력해주세요.")
            }

            else -> count
        }
    }
}