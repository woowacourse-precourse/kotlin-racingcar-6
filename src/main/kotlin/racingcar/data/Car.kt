package racingcar.data

data class Car(
    val name: String,
) {
    private var _location: Int = 0
    val location: Int
        get() = _location

    fun move() {
        _location++
    }

    override fun toString(): String = "$name : ${"-".repeat(_location)}"
}
