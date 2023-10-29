package race

import Controller.inputCarInformation
import Controller.inputRacingRoundInformation
import race.RacingSystemValues.COMPUTATION_OUTCOME
import race.RacingSystemValues.INIT_RACING_ROUND
import java.math.BigInteger

class RacingManager {
    private val racing = Racing()
    fun settingRacingCar() {
        racing.settingRacingCar(inputCarInformation())
    }

    fun raceStart() {
        val round = inputRacingRoundInformation()
        var nowRound = BigInteger(INIT_RACING_ROUND)
        println(COMPUTATION_OUTCOME)
        while (nowRound < round) {
            racing.start()
            nowRound++
        }
    }

    fun printWinner() {
        racing.printWinner()
    }
}
