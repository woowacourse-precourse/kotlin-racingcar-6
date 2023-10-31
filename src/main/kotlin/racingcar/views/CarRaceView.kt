package racingcar.views

class CarRaceView {
    fun showResults(allResult: List<String>) {
        println(allResult.joinToString("\n"))
    }

    fun showWinners(winners: String) {
        println("최종 우승자 : $winners")
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