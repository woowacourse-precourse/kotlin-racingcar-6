package racingcar.model

data class CarState(
    val name: String,
    val position: String,
) {
    override fun toString(): String {
        return "$name : $position"
    }
}