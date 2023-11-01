package racingcar

class Car(name: String) {
    val name: String = name
    var distance = 0

    fun moveForward() {
        distance++
    }
}
