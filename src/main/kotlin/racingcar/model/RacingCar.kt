package racingcar.model

data class RacingCar(val name: String, var numberOfMove: Int = 0) {
    fun moveForward() {
        this.numberOfMove += 1
    }
}