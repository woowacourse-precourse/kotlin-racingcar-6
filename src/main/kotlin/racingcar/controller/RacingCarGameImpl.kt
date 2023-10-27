package racingcar.controller

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.RacingCar

class RacingCarGameImpl : RacingCarGame {

    override fun createRacingCars(racingCars: List<String>): List<RacingCar> =
        racingCars.map { RacingCar(name = it.trim()) }

}