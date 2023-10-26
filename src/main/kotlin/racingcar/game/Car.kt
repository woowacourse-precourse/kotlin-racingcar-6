package racingcar.game

class Car {
    private var distance = 0

    fun getDistance() = distance

    fun move() {
        distance++
    }
}