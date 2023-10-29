package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class CarRace(
    private val attemptNumber: Int,
    private val carNames: List<String>,
    private val raceResult: RaceResult = RaceResult()
) {

    fun executeRacing() {
        val racingRoundResult: HashMap<String, ArrayList<Int>> = hashMapOf()
        repeat(attemptNumber) {
            carNames.forEach {
                racingRoundResult
                    .getOrPut(it) { arrayListOf() }
                    .add(setCarMoveState())
            }
        }
        raceResult.raceResult(racingRoundResult)
    }

    private fun setCarMoveState(): Int =
        if(Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE) >= POSSIBLE_FORWARD) FORWARD else STOP

    companion object {
        private const val MIN_VALUE = 0
        private const val MAX_VALUE = 0

        private const val POSSIBLE_FORWARD = 4

        private const val FORWARD = 1
        private const val STOP = 0
    }
}

data class RacingRound(
    val carName: String,
    val moveCount: Int
)