package racingcar.service

import racingcar.domain.RacingCarMover
import racingcar.domain.RacingCars
import racingcar.domain.RacingCarsComparator
import racingcar.domain.RacingGameWinners
import racingcar.repository.RacingCarsRepository
import racingcar.util.RandomNumberGenerator

class RacingCarService {
    private val racingCarsRepository = RacingCarsRepository()

    fun initGame(racingCars: RacingCars) {
        racingCarsRepository.saveRacingCars(racingCars)
    }

    fun moveRacingCars(): RacingCars {
        val racingCarMover = RacingCarMover()
        racingCarMover.moveRacingCars(
            racingCarsRepository.loadRacingCars(),
            RandomNumberGenerator()
        )
        return racingCarsRepository.loadRacingCars()
    }

    fun calculateRacingResult(): RacingGameWinners {
        val racingCarsComparator = RacingCarsComparator()
        return racingCarsComparator.calculateWinner(racingCarsRepository.loadRacingCars())
    }
}