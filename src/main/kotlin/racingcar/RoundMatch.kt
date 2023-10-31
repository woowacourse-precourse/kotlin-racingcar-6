package racingcar

class RoundMatch {
    fun start(cars: Cars, round: Round) {
        println(MATCH_RESULT)
        repeat(round.getRound()) { RoundPlayer(cars.getCars()).play() }
    }

    companion object {
        const val MATCH_RESULT = "실행 결과"
    }
}