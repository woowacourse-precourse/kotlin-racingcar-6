package racingcar

data class Car(val name: String, var distance: Int = 0) {

    fun goForward(step: Int) {
        distance += step
    }

    override fun toString(): String {
        return "$name : ${"_".repeat(distance)}"
    }
}
