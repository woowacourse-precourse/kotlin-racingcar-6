package racingcar.repository

import racingcar.domain.RacingCars

class RacingCarsRepository {
    private lateinit var racingCars: RacingCars
    fun saveRacingCars(racingCars: RacingCars) {
        this.racingCars = racingCars
    }

    fun loadRacingCars(): RacingCars = racingCars
}