package racingcar.service

import racingcar.domain.RacingCars
import racingcar.domain.RacingGameWinners
import racingcar.repository.RacingCarsRepository
import racingcar.util.RandomNumberGenerator

class RacingCarService(
    private val randomNumberGenerator: RandomNumberGenerator,
    private val racingCarsRepository: RacingCarsRepository
) {

    fun saveRacingCars(racingCars: RacingCars) {
        racingCarsRepository.saveRacingCars(racingCars)
    }

    fun moveRacingCars(): RacingCars {
        val loadRacingCars = racingCarsRepository.loadRacingCars()
        val randomNumbers = generateRandomNumbers(loadRacingCars)
        loadRacingCars.moveRacingCars(randomNumbers)
        return loadRacingCars
    }

    private fun generateRandomNumbers(loadRacingCars: RacingCars): MutableList<Int> {
        val randomNumbers = mutableListOf<Int>()
        repeat(loadRacingCars.racingCarsSize()) {
            randomNumbers.add(randomNumberGenerator.generateRandomNumber())
        }
        return randomNumbers
    }

    fun calculateRacingResult(): RacingGameWinners {
        val loadRacingCars = racingCarsRepository.loadRacingCars()
        return loadRacingCars.calculateWinner()
    }
}