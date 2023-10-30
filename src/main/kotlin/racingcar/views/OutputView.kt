package racingcar.views

class OutputView {

    fun printSoloGameRules() {
        println("단독 출전 시 2번 게임 진행 후 1회 이상 전진 시 우승입니다.")
    }

    fun printSoloGameResult(inputCarName: String, forward: String) {
        printResultForm(inputCarName, forward)
        skipLine()
    }

    fun printMultiGameResult(multiCarName: List<String?>, scoreMap: Map<String, Int>) {
        for (carName in multiCarName) {
            val score = scoreMap.getOrDefault(carName, 0)
            val forward = "-".repeat(score)
            printResultForm(carName!!, forward)
        }
        skipLine()
    }

    private fun printResultForm(carName: String, forward: String) {
        println("$carName : $forward")
    }

    fun printResultMessage() {
        skipLine()
        println("실행 결과")
    }

    fun printSoloWinner(carName: String) {
        println("최종 우승자 : $carName")
    }

    fun printMultiWinner(winners: Set<String>) {
        println("최종 우승자 : ${winners.joinToString(",")}")
    }

    fun printNoWinner() {
        println("우승자가 없습니다")
    }

    private fun skipLine() {
        println("")
    }
}
