package racingcar.domain

data class Car(
    val name: String,
    var advanceState: Int = 0,
) {
    fun moveForward() {
        advanceState++
    }
}