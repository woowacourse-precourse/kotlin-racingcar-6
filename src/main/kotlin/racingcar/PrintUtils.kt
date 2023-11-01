package racingcar

object PrintUtils {
    fun printIntroduction() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }

    fun printTryCount() {
        println("시도할 횟수는 몇 회인가요?")
    }

    fun printGameIntroduction() {
        println("\n실행 결과")
    }

    fun printRoundResults(results: List<String>) {
        println(results.joinToString("\n"))
        println()
    }

    fun printWinners(winnerNames: String) {
        println("최종 우승자: $winnerNames")
    }
}
