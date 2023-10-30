package racingcar.domain

class RaceResult(private val winner: Winner = Winner()) {
    fun raceResult(
        racingRoundResult: HashMap<String, ArrayList<Int>>,
        carNames: List<String>,
        attemptCount: Int,
    ): String {
        val racingResultFormat = StringBuilder()
        val racingResult = racingRoundResult.mapValues { (_, moveCount) -> moveCount.sumMoveCount() }

        repeat(attemptCount) { count ->
            val racingRound = carNames.executeRacingRound(
                index = count,
                racingResult = racingResult
            )
            racingResultFormat.append(racingRound).append(NEW_LINE)
        }
        return racingResultFormat.removeSuffix(NEW_LINE).toString()
    }

    private fun ArrayList<Int>.sumMoveCount(): ArrayList<Int> {
        val moveCountList: ArrayList<Int> = arrayListOf()
        var sum = 0
        for (moveCount in this) {
            sum += moveCount
            moveCountList.add(sum)
        }
        return moveCountList
    }

    private fun List<String>.executeRacingRound(
        index: Int,
        racingResult: Map<String, ArrayList<Int>>
    ): String {
        var racingRound = ""
        forEach { carName ->
            val moveCount = racingResult.getValue(carName)[index]
            racingRound += "$carName : ${convertCountSign(moveCount)}\n"
        }
        return racingRound
    }

    private fun convertCountSign(count: Int): String {
        var countSign = ""
        repeat(count) { countSign += MOVE_COUNT_SIGN }
        return countSign
    }

    fun raceWinner(racingRoundResult: Map<String, ArrayList<Int>>): String {
        return winner.raceGameWinner(racingRoundResult.mapValues { (_, moveCount) -> moveCount.sumMoveCount() })
    }

    companion object {
        private const val MOVE_COUNT_SIGN = "-"
        private const val NEW_LINE = "\n"
    }
}