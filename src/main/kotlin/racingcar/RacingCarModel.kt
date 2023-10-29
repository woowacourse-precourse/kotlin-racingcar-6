package racingcar

class RacingCarModel(
    var racerCrew: Racer = Racer(),
    var raceMove: RaceMove = RaceMove()
) {
    fun requestUpdateRacerName(racerName: MutableList<String>) {
        racerCrew.updateRacerName(racerName)
    }

    fun requestInitializationMoveForward() {
        racerCrew.initializationMoveForward()
    }

    fun requestUpdatePlayTime(playTime: Int) {
        racerCrew.updatePlayTime(playTime)
    }

    fun requestUpdateMoveForward(moveForward: RaceMove) {
        racerCrew.updateMoveForward(moveForward)
    }

}