package racingcar.views

class CarRaceView {
    fun showResults(carNameAndScore: Map<String, Int>) {
        for ((carName, score) in carNameAndScore) {
            val scoreResult = "-".repeat(score)
            println("$carName : $scoreResult")
        }
    }

    fun showWinners(carNameAndScore: Map<String, Int>) {
        val winners = carNameAndScore.filter { it.value == carNameAndScore.values.maxOrNull() }.keys
        println("최종 우승자 : ${winners.joinToString(", ")}")
    }

    fun printSentenceWriteCarName() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }

    fun printSentenceWordWriteAttempts() {
        println("시도할 횟수는 몇 회인가요?")
    }

    fun printSentenceResult() {
        println("실행 결과")
    }
}