package racingcar

class OutputView {
    companion object {
        fun printExecutionResultMention() = println("실행 결과")

        fun printExecutionResult(list : List<Car>) {
            val sb = StringBuilder()
            list.forEach {
                 sb.append("${it.name} : ${printCurrentPosition(it.getPosition())}\n")
            }
            sb.append("\n")
            println(sb)
        }

        fun printCurrentPosition(position : Int) : String {
            var curPosition = ""
            for(i in 0 until position) curPosition += "-"
            return curPosition
        }

        fun printWinners(nameList : List<String>) {
            println("최종 우승자 : ${nameList.joinToString(", ")}")
        }


    }
}