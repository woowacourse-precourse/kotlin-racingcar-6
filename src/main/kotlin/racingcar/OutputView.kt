package racingcar

class OutputView {
    fun startCommand() = println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    fun getCountCommand() = println("시도할 횟수는 몇번인가요?")
    fun winnerOutput(winners: String) { println("최종 우승자 : $winners") }
    private fun nameOutput(name: String) = print("$name : ")
    private fun scoreOutput(score: Int) = repeat(score) { print('-') }

    fun resultOutput(name: String, score: Int) {
        nameOutput(name)
        scoreOutput(score)
        println()
    }
}