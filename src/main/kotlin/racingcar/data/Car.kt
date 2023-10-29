package racingcar.data

data class Car(
    val name: String,
) {
    val id: Int = numForId
    private var _location: Int = 0
    val location: Int
        get() = _location

    init {
        numForId++
    }

    fun move() {
        _location++
    }

    override fun toString(): String = "$name : ${"-".repeat(_location)}"

    companion object {
        private var numForId = 0
    }
}
