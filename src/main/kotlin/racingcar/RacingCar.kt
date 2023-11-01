package racingcar

class RacingCar(private val name: String) {
    private var position = 0

    fun getName(): String = this.name
    fun getPosition(): Int = this.position

    fun move() {
        position++
    }
}