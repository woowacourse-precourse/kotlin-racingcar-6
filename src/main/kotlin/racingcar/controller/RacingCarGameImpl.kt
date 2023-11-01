package racingcar.controller

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.RacingCar
import racingcar.utils.Constant.MAX_RANGE_VALUE
import racingcar.utils.Constant.MIN_RANGE_VALUE
import racingcar.utils.Constant.MOVE_THRESHOLD

class RacingCarGameImpl : RacingCarGame {

    override fun createRacingCars(racingCars: List<String>): List<RacingCar> =
        racingCars.map { RacingCar(name = it.trim()) }

    override fun canRacingCarMove(): Boolean =
        Randoms.pickNumberInRange(MIN_RANGE_VALUE, MAX_RANGE_VALUE) >= MOVE_THRESHOLD

    override fun moveRacingCars(racingCars: List<RacingCar>): List<RacingCar> {
        return racingCars.map { racingCar ->
            if (canRacingCarMove()) racingCar.move()
            else racingCar
        }
    }

    override fun getWinners(racingCars: List<RacingCar>): String {
        val maxRaceRecordPosition = racingCars.maxOf { it.position }
        val winners = racingCars.filter { it.position == maxRaceRecordPosition }
        return winners.joinToString(", ") { it.name }
    }
}