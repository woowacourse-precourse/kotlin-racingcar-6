package racingcar

class RaceTime(private val moveChance: Int = INITIALIZATION) {
    fun verifyPlayTime(): Int{
        checkPlayTimeRange()
        return moveChance
    }

    private fun checkPlayTimeRange(){
        if(moveChance < PLAYTIME_MINIMUM || PLAYTIME_MAXIMUM < moveChance)
            throw IllegalArgumentException(Message.RACE_TIME_RANGE_ERROR.messageText)
    }
}