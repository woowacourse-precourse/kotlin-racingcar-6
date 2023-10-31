package racingcar

class GameMatch {
    fun start(cars: Cars, round: Round) {
        println(MATCH_RESULT)
        repeat(round.getRound()) { cars.showRoundResult() }
    }

    companion object {
        const val MATCH_RESULT = "실행 결과"
    }
}