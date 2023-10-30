package racingcar.domain

class RaceResult(private val winner: Winner = Winner()) {
    fun raceResult(
        racingMoveResult: Map<String, ArrayList<Int>>,
        carNames: List<String>,
        attemptCount: Int,
    ): String {
        val formattedRacingResult = StringBuilder()
        val racingResult = racingMoveResult.mapValues { (_, moveCount) -> moveCount.sumMoveCount() }

        repeat(attemptCount) { count ->
            val racingRound = carNames.convertRacingRound(
                index = count,
                racingResult = racingResult
            )
            formattedRacingResult
                .append(racingRound)
                .append(NEW_LINE)
        }
        return formattedRacingResult.removeSuffix(NEW_LINE).toString()
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

    private fun List<String>.convertRacingRound(
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

    fun raceWinner(racingMoveResult: Map<String, ArrayList<Int>>): String {
        val racingResult = racingMoveResult.mapValues { (_, moveCount) -> moveCount.sumMoveCount() }
        return winner.raceGameWinner(racingResult)
    }

    companion object {
        private const val MOVE_COUNT_SIGN = "-"
        private const val NEW_LINE = "\n"
    }
}