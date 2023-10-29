package racingcar.domain

class RaceResult(private val attemptNumber: Int) {
    fun getRaceResult(moveResultList: ArrayList<MoveResult>) {
        repeat(attemptNumber) {
            raceResultList.add(executeRace())
        }
    }
}