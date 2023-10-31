package racingcar.model

import racingcar.RandomGenerator

class Judge(
    private val raceParticipants: RaceParticipants,
    private val attempt: Attempt
) {

    private val board = Board.create(raceParticipants.getNamesOfParticipants(), attempt)

    fun play(): Board {
        repeat(attempt) { executeMove(attempt) }
        return board
    }

    fun getWinner(): List<CarName> = raceParticipants.getCarsWithLongestDistance().map { car -> car.name }

    private fun executeMove(attempt: Attempt) {
        raceParticipants.getNamesOfParticipants().forEach { carName ->
            if (isAvailableMove()) {
                val score = raceParticipants.moveCar(carName)
                board.addScore(carName, attempt, score)
            }
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
    }
}