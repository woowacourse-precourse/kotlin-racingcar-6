package racingcar

data class RacingCar(val carName: String, var totalMove: Int = 0) {
    fun move() {
        this.totalMove += 1
    }
}