package racingcar.controller

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.RacingCar

class RacingCarGameImpl : RacingCarGame {

    override fun createRacingCars(racingCars: List<String>): List<RacingCar> =
        racingCars.map { RacingCar(name = it.trim()) }

    override fun canRacingCarMove(): Boolean = Randoms.pickNumberInRange(0, 9) >= 4

    override fun moveRacingCars(racingCars: List<RacingCar>): List<RacingCar> {
        return racingCars.map { racingCar ->
            if (canRacingCarMove()) racingCar.move()
            else racingCar
        }
    }
}