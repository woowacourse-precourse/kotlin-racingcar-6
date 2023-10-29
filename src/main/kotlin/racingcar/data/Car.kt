package racingcar.data

data class Car(
    val name: String,
) {
    val id: Int = numForId
    private var location: Int = 0

    init {
        numForId++
    }

    fun move() {
        location++
    }

    override fun toString(): String = "$name($id) : ${"-".repeat(location)}"

    companion object {
        private var numForId = 0
    }
}
