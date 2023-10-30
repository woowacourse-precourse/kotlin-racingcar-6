package racingcar.model

import racingcar.RandomGenerator

class Judge(private val raceParticipants: RaceParticipants) {

    fun play(): RaceParticipants {
        raceParticipants.cars.forEach(::calculate)
        return raceParticipants
    }

    fun getWinner(): List<Car> = raceParticipants.getCarsWithLongestDistance()

    private fun calculate(car: Car) {
        val score = RandomGenerator.pickNumber(RANDOM_START_NUMBER, RANDOM_END_NUMBER)
        if (score >= MOVING_POINT) {
            car.moveForward()
        }
    }

    companion object {
        private const val RANDOM_START_NUMBER = 0
        private const val RANDOM_END_NUMBER = 9
        private const val MOVING_POINT = 4
    }
}