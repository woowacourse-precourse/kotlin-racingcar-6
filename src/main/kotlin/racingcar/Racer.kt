package racingcar

class Racer (
    var racerName: MutableList<String> = mutableListOf(),
    var moveDistance: MutableList<Int> = mutableListOf(),
    var playTime: Int = INITIALIZATION
) {
    fun updateRacerName(racerName:MutableList<String>) {
        this.racerName = racerName
    }

    fun initializationMoveDistance() {
        this.moveDistance = MutableList(racerName.size) { INITIALIZATION }
    }

    fun updateMoveDistance(moveDistance: RaceMove) {
        for (index in moveDistance.moveChanceNumber.indices) {
            this.moveDistance[index] += moveDistance.moveChanceNumber[index]
        }
    }

    fun updatePlayTime(playTime:Int) {
        this.playTime = playTime
    }
}