package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class CarRace(
    private val attemptNumber: Int,
    private val carNames: List<String>,
    private val raceResult: RaceResult = RaceResult()
) {
    fun executeRacingAllRound(carNames: List<String>): ArrayList<MoveResult> {
        repeat(attemptNumber) {

        }
    }

    fun executeRacingRound(): List<MoveResult> {
        val moveResultList = arrayListOf<MoveResult>()
        carNames.forEach { carName ->
            val moveResult = MoveResult(
                carName = carName,
                moveCount = setCarMoveState()
            )
            moveResultList.add(moveResult)
        }
        return moveResultList
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

data class MoveResult(
    val carName: String = "",
    val moveCount: Int = 0
)