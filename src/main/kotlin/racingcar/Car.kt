package racingcar

class Car(private val name: String) {
    private var _moveDistance: Int = 0
    val moveDistance: Int
        get() = _moveDistance

    fun moveOneStep() = _moveDistance++
}