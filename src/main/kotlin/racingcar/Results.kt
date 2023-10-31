package racingcar

class Results {
    // 우승자 출력
    fun printResults(winners: List<String>) {
        println("최종 우승자 : ${winners.joinToString(", ")}")
    }
}