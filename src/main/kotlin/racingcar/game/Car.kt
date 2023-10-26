package racingcar.game

class Car {
    private var distance = STARTING_POINT

    fun getDistance() = distance

    fun move() {
        distance++
    }

    companion object {
        private const val STARTING_POINT = 0
    }
}