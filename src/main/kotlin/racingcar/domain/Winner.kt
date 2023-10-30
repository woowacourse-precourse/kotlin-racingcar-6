package racingcar.domain

class Winner {
    fun raceGameWinner(racingResult: Map<String, ArrayList<Int>>): String {
        val winner = StringBuilder(WINNER)
        val moveMaxCount = racingResult.maxBy { racingRound -> racingRound.value.max() }.value.max()

        racingResult.forEach { racingRound ->
            val isMaxMoveCountMultiple = racingRound.value.findMaxMoveCount(moveMaxCount)
            if (isMaxMoveCountMultiple) winner.append(racingRound.key).append(SPACE_COMMA)
        }
        return winner.toString().removeSuffix(SPACE_COMMA)
    }

    private fun ArrayList<Int>.findMaxMoveCount(maxMoveCount: Int): Boolean = contains(maxMoveCount)

    companion object {
        private const val WINNER = "최종 우승자 : "
        private const val SPACE_COMMA = ", "
    }
}