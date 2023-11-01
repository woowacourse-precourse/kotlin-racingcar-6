package racingcar.model

import racingcar.RandomGenerator

class Judge private constructor(
    private val raceParticipants: RaceParticipants,
    private val round: Round
) {

    private val board = Board.of(raceParticipants.getNamesOfParticipants(), round)

    /**
     * 경기를 시작하고 경기의 모든 진행 결과를 담은 [Board] 객체를 반환함
     * */
    fun startRace(): Board {
        round.forEach { currentRound -> executeMove(currentRound) }
        return board
    }

    fun getWinner(): List<CarName> = raceParticipants.getCarsWithLongestDistance().map { car -> car.name }

    private fun executeMove(round: Round) {
        raceParticipants.getNamesOfParticipants().forEach { carName ->
            if (isAvailableMove()) {
                raceParticipants.moveCar(carName)
            }
            board.recordRaceResult(carName, round, raceParticipants.getDistance(carName))
        }
    }

    private fun isAvailableMove(): Boolean {
        val score = RandomGenerator.pickNumber(RANDOM_START_NUMBER, RANDOM_END_NUMBER)
        return score >= MOVING_POINT
    }

    companion object {
        private const val RANDOM_START_NUMBER = 0
        private const val RANDOM_END_NUMBER = 9
        private const val MOVING_POINT = 4

        fun of(participantsString: String, roundString: String): Judge {
            val participants = RaceParticipants.from(participantsString)
            val round = Round.from(roundString)
            return Judge(participants, round)
        }
    }
}