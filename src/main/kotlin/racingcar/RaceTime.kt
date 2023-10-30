package racingcar

class RaceTime(private val moveChance: Int = 0) {
    fun verifyPlayTime(): Int{
        checkPlayTimeRange()
        return moveChance
    }

    private fun checkPlayTimeRange(){
        if(moveChance < 1 || 10 < moveChance) throw IllegalArgumentException(Message.RaceTimeRangeError.messageText)
    }
}