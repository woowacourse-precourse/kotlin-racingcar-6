package racingcar

class RaceTime(val movechance: Int = 0) {
    fun verifyPlayTime(): Int{
        checkPlayTimeRange()
        return movechance
    }

    private fun checkPlayTimeRange(){
        if(movechance < 1 || 10 < movechance) throw IllegalArgumentException("이동 시도 횟수는 최소 1회, 최대 10회 입니다.")
    }
}