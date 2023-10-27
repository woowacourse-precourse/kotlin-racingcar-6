package racingcar.domain

class RacingCarsComparator {
    fun calculateWinner(racingCars: RacingCars): RacingGameWinners {
        val fastestPosition: Int = racingCars.loadRacingCars().maxOf { it.receiveForwardCount() }
        val winners = racingCars.loadRacingCars().filter { it.receiveForwardCount() == fastestPosition }
        val winnerNames = mutableListOf<String>()
        winners.forEach { winnerNames.add(it.readRacingCarName()) }
        return RacingGameWinners(winnerNames)
    }
}