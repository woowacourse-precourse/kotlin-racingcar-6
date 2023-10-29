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
        for (index in moveForward.moveChanceNumber.indices) {
            if (index < moveForward.moveChanceNumber.size && index < this.moveForward.size) {
                this.moveForward[index] += moveForward.moveChanceNumber[index]
            }
        }
    }

    fun updatePlayTime(playTime:Int) {
        this.playTime = playTime
    }
}