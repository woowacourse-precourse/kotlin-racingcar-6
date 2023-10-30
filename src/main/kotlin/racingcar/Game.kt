package racingcar

class Game {

    private val cars: Cars = Cars()
    private var round: Int = 0

    fun start() {
        initGameInfo()
        matchStart()
    }

    private fun initGameInfo() {
        setPlayerCars()
        setRoundCount()
    }

    private fun setPlayerCars() {
        println(START_INFO)
        cars.init()
    }

    private fun setRoundCount() {
        println(ROUND_COUNT_QUESTION)
        round = RoundInput().result()
    }

    private fun matchStart() {
        println(MATCH_RESULT)
        repeat(round) { cars.showRoundResult() }
    }

    companion object {
        const val START_INFO = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val ROUND_COUNT_QUESTION = "시도할 횟수는 몇 회인가요?"
        const val MATCH_RESULT = "실행 결과"
        const val WINNER_INFO = "최종 우승자 : "
    }
}