package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class CarRace(
    attemptNumber: Int,
    private val raceResult: RaceResult = RaceResult(attemptNumber)
) {
    fun executeRace(carNames: List<String>) {
        val moveResultList = arrayListOf<MoveResult>()
        carNames.forEach { carName ->
            val moveResult = MoveResult(
                carName = carName,
                moveCount = move()
            )
            moveResultList.add(moveResult)
        }
    }

    private fun move(): Int =
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