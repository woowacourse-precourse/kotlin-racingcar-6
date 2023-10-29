package racingcar

class RaceTime(private val moveChance: Int = 0) {
    fun verifyPlayTime(): Int{
        checkPlayTimeRange()
        return moveChance
    }

    private fun checkPlayTimeRange(){
        if(moveChance < 1 || 10 < moveChance) throw IllegalArgumentException("이동 시도 횟수는 최소 1회, 최대 10회 입니다.")
    }
}