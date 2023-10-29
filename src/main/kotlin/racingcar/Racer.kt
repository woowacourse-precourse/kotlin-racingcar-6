package racingcar


class Racer (
    private var racerName: MutableList<String> = mutableListOf(),
    private var moveForward: MutableList<Int> = mutableListOf(),
    private var playTime: Int = 0
) {
    fun updateRacerName(racerName:MutableList<String>){
        this.racerName = racerName
    }

    fun getMoveForward(moveForward: MutableList<Int>){
        this.moveForward = moveForward
    }

    fun updatePlayTime(playTime:Int){
        this.playTime = playTime
    }
}