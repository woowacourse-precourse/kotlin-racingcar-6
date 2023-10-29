package racingcar

class Racer (
    var racerName: MutableList<String> = mutableListOf(),
    var moveForward: MutableList<Int> = mutableListOf(),
    var playTime: Int = 0
) {
    fun updateRacerName(racerName:MutableList<String>) {
        this.racerName = racerName
    }

    fun initializationMoveForward() {
        moveForward = MutableList(racerName.size) { 0 }
    }

    fun updateMoveForward(moveForward: RaceMove) {
        for (i in moveForward.moveChanceNumber.indices) {
            if (i < moveForward.moveChanceNumber.size && i < this.moveForward.size) {
                this.moveForward[i] += moveForward.moveChanceNumber[i]
            }
        }
    }

    fun updatePlayTime(playTime:Int) {
        this.playTime = playTime
    }
}