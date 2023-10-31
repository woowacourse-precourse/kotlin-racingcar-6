package racingcar.repository

import racingcar.constant.ErrorMessage
import racingcar.domain.RacingCars

class RacingCarsRepository {
    private var racingCars: RacingCars? = null
    fun saveRacingCars(racingCars: RacingCars) {
        this.racingCars = racingCars
    }


    fun loadRacingCars(): RacingCars = racingCars
        ?: throw NullPointerException(ErrorMessage.EMPTY_RACINGCARS.message)
}