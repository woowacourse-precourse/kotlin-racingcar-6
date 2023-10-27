package racingcar

class Car(private val _name: String) {
    private var _moveDistance: Int = 0
    val moveDistance: Int
        get() = _moveDistance

    val name: String
        get() = _name

    fun moveOneStep() = _moveDistance++
}