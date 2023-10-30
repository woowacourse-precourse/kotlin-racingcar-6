package racingcar.domain

class RaceResult(private val winner: Winner = Winner()) {
    fun raceResult(
        racingRoundResult: HashMap<String, ArrayList<Int>>,
        carNames: List<String>,
        attemptCount: Int,
    ): String {
        val racingResult = racingRoundResult.mapValues { (_, moveCount) -> moveCount.sumMoveCount() }
        val racingResultFormat = StringBuilder()

        repeat(attemptCount) { count ->
            val executeRacing = carNames.executeRacing(
                index = count,
                racingResult = racingResult
            )
            racingResultFormat.apply {
                append(executeRacing)
                append("\n")
            }
        }
        return racingResultFormat.toString()
    }

    fun getRaceWinner(racingRoundResult: Map<String, ArrayList<Int>>): String {
        return winner.raceGameWinner(racingRoundResult)
    }

    private fun List<String>.executeRacing(
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
        repeat(count) { countSign += "-" }
        return countSign
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
}