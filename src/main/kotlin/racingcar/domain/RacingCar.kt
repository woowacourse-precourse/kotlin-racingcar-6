package racingcar.domain

class RacingCar(name: String, private var position: Int = 0) {
    private val name: CarName = CarName(name)

    fun move(randomNumber: Int) {
        if (randomNumber >= 4) {
            position += 1
        }
    }

    fun getName(): CarName = name

    fun getPosition(): Int = position

    override fun toString() = "$name : ${"-".repeat(position)}"
}
