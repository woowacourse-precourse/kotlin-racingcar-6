package race

import Controller.inputCarInformation
import Controller.inputRacingRoundInformation

class RacingManager {
    private val racing = Racing()
    fun settingRacingCar() {
        racing.settingRacingCar(inputCarInformation())
    }

    fun settingRacingRound() {
        racing.settingRacingRound(inputRacingRoundInformation())
    }
}
