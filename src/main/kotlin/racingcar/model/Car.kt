package racingcar.model

class Car(var name: String) {
    var score: Int = 0
    fun move() = score++
}