package racingcar.controller

import racingcar.model.RacingCar

interface RacingCarGame {
    fun createRacingCars(racingCars: List<String>): List<RacingCar>
    fun canRacingCarMove(): Boolean
    fun moveRacingCars(racingCars: List<RacingCar>): List<RacingCar>
    fun getWinners(racingCars: List<RacingCar>): String
}
