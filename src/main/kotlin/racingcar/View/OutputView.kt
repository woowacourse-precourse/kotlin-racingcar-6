package racingcar.View

import camp.nextstep.edu.missionutils.Console
import racingcar.Model.Car
import racingcar.Utils.Constans.EXECUTION_RESULT_MENTION

class OutputView {
    companion object {
        fun printExecutionResultMention() = println(EXECUTION_RESULT_MENTION)

        fun printExecutionResult(list: List<Car>) {
            val sb = StringBuilder()
            list.forEach {
                sb.append("${it.name} : ${printCurrentPosition(it.getPosition())}\n")
            }
            println(sb)
        }

        private fun printCurrentPosition(position: Long): String {
            var curPosition = ""
            for (i in 0 until position) curPosition += "-"
            return curPosition
        }

        fun printWinners(nameList: List<String>) {
            print("최종 우승자 : ${nameList.joinToString(", ")}")
        }
    }
}