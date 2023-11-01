package racingcar.model

class Car(val name: CarName) {

    private var _distance = 0
    val distance: Int get() = _distance

    fun moveForward(): Int = ++_distance
}

@JvmInline
value class CarName(val value: String) {

    init {
        this.validateCarName().getOrThrow()
    }

    override fun toString(): String = value
}