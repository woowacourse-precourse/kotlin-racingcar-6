package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class CarRace(
    private val attemptNumber: Int,
    private val carNames: List<String>,
    private val raceResult: RaceResult = RaceResult()
) {
    private var raceMoveResult: LinkedHashMap<String, ArrayList<Int>> = linkedMapOf()
    fun winner(): String = raceResult.raceWinner(raceMoveResult)

    fun racingResult(): String {
        repeat(attemptNumber) { setRacingRound(raceMoveResult) }

        return raceResult.raceResult(
            racingRoundResult = raceMoveResult,
            attemptCount = attemptNumber,
            carNames = carNames
        )
    }

    private fun setRacingRound(move: LinkedHashMap<String, ArrayList<Int>>) {
        carNames.forEach { carName ->
            move.getOrPut(carName) { arrayListOf() }.add(moveResult())
        }
    }

    private fun moveResult(): Int =
        if(Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE) >= POSSIBLE_FORWARD) FORWARD else STOP

    companion object {
        private const val MIN_VALUE = 0
        private const val MAX_VALUE = 9

        private const val POSSIBLE_FORWARD = 4

        private const val FORWARD = 1
        private const val STOP = 0
    }
}