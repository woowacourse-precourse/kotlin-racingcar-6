package racingcar.view

object OutputView {

    fun printRoundResults(roundResults: List<Map<String, Int>>) {
        println("\n실행결과")
        roundResults.forEach { roundResult ->
            roundResult.forEach { (name, position) ->
                println("$name : ${"-".repeat(position)}")
            }
            println()
        }
    }

    fun printWinners(winners: Set<String>) {
        println("최종 우승자 : ${winners.joinToString(", ")}")
    }
}