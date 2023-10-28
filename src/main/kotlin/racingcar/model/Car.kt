package racingcar.model

class Car(
    name: String,
    private var _position: Int = 0
) {
    val name: CarName = CarName(name)
    val position: Int
        get() = _position

    fun move() {
        _position++
    }
}