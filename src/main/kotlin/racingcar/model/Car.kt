package racingcar.model

class Car(val name: String) {

    private var _distance = 0
    val distance: Int get() = _distance

    init {
        name.validateCarName().getOrThrow()
    }

    fun moveForward() {
        _distance++
    }
}