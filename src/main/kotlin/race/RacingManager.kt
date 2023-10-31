package race

import Controller.inputCarInformation
import Controller.inputRacingRoundInformation
import car.Car
import race.RacingSystemValues.COMPUTATION_OUTCOME
import race.RacingSystemValues.INIT_RACING_ROUND
import java.math.BigInteger

class RacingManager(private val racing: Racing) {

    private lateinit var racingCarList: List<Car>
    private lateinit var round: BigInteger

    init {
        settingRacingCar()
        settingRaceRound()
        raceStart()
        printWinner()
    }

    private fun settingRacingCar() {
        racingCarList = inputCarInformation()
    }

    private fun settingRaceRound() {
        round = inputRacingRoundInformation()
    }

    private fun raceStart() {
        var nowRound = BigInteger(INIT_RACING_ROUND)
        println(COMPUTATION_OUTCOME)
        while (nowRound < round) {
            print(racing.start(racingCarList))
            nowRound++
        }
    }

    private fun printWinner() {
        print(racing.printWinner(racingCarList))
    }
}
