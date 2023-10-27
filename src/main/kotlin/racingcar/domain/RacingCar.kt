package racingcar.domain

class RacingCar(private val name: String) {
    private var forwardCount = INIT_FORWARD_COUNT

    fun addForwardCount() {
        forwardCount++
    }

    fun countForwardCount(): Int = forwardCount

    fun readRacingCarName(): String = name

    companion object {
        private const val INIT_FORWARD_COUNT = 0
    }
}