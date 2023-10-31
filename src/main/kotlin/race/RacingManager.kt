package race

import Controller.inputCarInformation
import Controller.inputRacingRoundInformation
import car.Car
import car.CarFactory.makeCar
import race.RacingSystemValues.COMPUTATION_OUTCOME
import race.RacingSystemValues.INIT_RACING_ROUND
import java.math.BigInteger

class RacingManager(private val racing: Racing) {

    private lateinit var racingCarList: List<Car>

    init {
        settingRacingCar()
        raceStart()
        printWinner()
    }

    private fun settingRacingCar() {
        val tempCarList = mutableListOf<Car>()
        inputCarInformation().forEach {
            tempCarList.add(makeCar(it))
        }
        racingCarList = tempCarList
    }

    private fun raceStart() {
        val round = inputRacingRoundInformation()
        var nowRound = BigInteger(INIT_RACING_ROUND)
        println(COMPUTATION_OUTCOME)
        while (nowRound < round) {
            racing.start()
            nowRound++
        }
    }

    private fun printWinner() {
        racing.printWinner()
    }
}
