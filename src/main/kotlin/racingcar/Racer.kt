package racingcar

class Racer (
    var racerName: MutableList<String> = mutableListOf(),
    var moveForward: MutableList<Int> = mutableListOf(),
    var playTime: Int = INITIALIZATION
) {
    fun updateRacerName(racerName:MutableList<String>) {
        this.racerName = racerName
    }

    fun initializationMoveForward() {
        this.moveForward = MutableList(racerName.size) { INITIALIZATION }
    }

    fun updateMoveForward(moveForward: RaceMove) {
        for (index in moveForward.moveChanceNumber.indices) {
            this.moveForward[index] += moveForward.moveChanceNumber[index]
        }
    }

    fun updatePlayTime(playTime:Int) {
        this.playTime = playTime
    }
}