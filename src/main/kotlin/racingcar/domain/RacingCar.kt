package racingcar.domain

class RacingCar(private val name: String) {
    private var forwardCount = INIT_FORWARD_COUNT


    fun readForwardCount(): Int = forwardCount

    fun readRacingCarName(): String = name


    fun moveRacingCar(randomNumber: Int) {
        if (randomNumber >= BOUNDARY_NUMBER) {
            forwardCount++
            return
        }
    }


    companion object {
        private const val INIT_FORWARD_COUNT = 0
        private const val BOUNDARY_NUMBER = 4
    }
}