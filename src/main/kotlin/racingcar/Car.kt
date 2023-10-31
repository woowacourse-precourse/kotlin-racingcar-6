package racingcar

data class Car(
    val name: String,
) {
    var position: Int = 0
        private set

    fun moveForward() {
        position++
    }

    override fun toString(): String {
        val positionIndicator = "-".repeat(position)
        return "$name : $positionIndicator"
    }
}
