package racingcar.domain

class RaceResult(private val winner: Winner = Winner()) {
    fun raceResult(racingRoundResult: HashMap<String, ArrayList<Int>>): Map<String, ArrayList<Int>> {
        return racingRoundResult.mapValues { (_, moveCount) -> moveCount.sumMoveCount() }
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