package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

class Car(
    private val carNames: List<String>,
    private val attemptCount: Int
) {
    fun race() {
        
    }
    private fun executeRace(): ArrayList<MoveResult> {
        val moveResultList = arrayListOf<MoveResult>()
        carNames.forEach { carName ->
            val moveResult = MoveResult(
                carName = carName,
                moveCount = isMovable()
            )
            moveResultList.add(moveResult)
        }
        return moveResultList
    }

    private fun isMovable(): Int =
         if(pickNumberInRange(MIN_VALUE, MAX_VALUE) >= POSSIBLE_FORWARD) FORWARD else STOP

    companion object {
        private const val MIN_VALUE = 0
        private const val MAX_VALUE = 0

        private const val POSSIBLE_FORWARD = 4

        private const val FORWARD = 1
        private const val STOP = 1
    }
}

data class MoveResult(
    val carName: String = "",
    val moveCount: Int = 0
)