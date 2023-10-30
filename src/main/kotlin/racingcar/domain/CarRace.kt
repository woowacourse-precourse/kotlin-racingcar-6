package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms
import net.bytebuddy.dynamic.scaffold.MethodGraph.Linked

class CarRace(
    private val attemptNumber: Int,
    private val carNames: List<String>,
    private val raceResult: RaceResult = RaceResult()
) {

    fun racingResult(): Unit {
        val racingRoundResult: LinkedHashMap<String, ArrayList<Int>> = linkedMapOf()
        repeat(attemptNumber) { setRacingRound(racingRoundResult) }

        return raceResult.raceResult(
            racingRoundResult = racingRoundResult,
            attemptCount = attemptNumber,
            carNames = carNames
        )
    }

    fun winner(racingRoundResult: Map<String, ArrayList<Int>>) {
        raceResult.getRaceWinner(racingRoundResult)
    }

    private fun setRacingRound(round: LinkedHashMap<String, ArrayList<Int>>) {
        carNames.forEach { carName ->
            round.getOrPut(carName) { arrayListOf() }.add(setCarMoveState())
        }
    }

    private fun setCarMoveState(): Int =
        if(Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE) >= POSSIBLE_FORWARD) FORWARD else STOP

    companion object {
        private const val MIN_VALUE = 0
        private const val MAX_VALUE = 9

        private const val POSSIBLE_FORWARD = 4

        private const val FORWARD = 1
        private const val STOP = 0
    }
}