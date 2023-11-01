package racingcar

class RacingCarModel(
    var racerCrew: Racer = Racer(),
    val raceChampion: Champion = Champion()
) {
    fun requestUpdateRacerName(racerName: MutableList<String>) {
        racerCrew.updateRacerName(racerName)
    }

    fun requestInitializationMoveDistance() {
        racerCrew.initializationMoveDistance()
    }

    fun requestUpdatePlayTime(playTime: Int) {
        racerCrew.updatePlayTime(playTime)
    }

    fun requestUpdateMoveDistance(moveDistance: RaceMove) {
        racerCrew.updateMoveDistance(moveDistance)
    }

    fun requestJudgeChampion() {
        raceChampion.getChampion(racerCrew)
    }
}