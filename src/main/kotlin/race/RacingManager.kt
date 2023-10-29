package race

import Controller.inputCarInformation
class RacingManager {
    private val racing = Racing()
    fun settingRacingCar() {
        racing.settingRacingCar(inputCarInformation())
    }

}