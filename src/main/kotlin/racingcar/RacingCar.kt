package racingcar

class RacingCar(private val name: String) {
    private var position = 0

    fun move() {
        position++
    }
}