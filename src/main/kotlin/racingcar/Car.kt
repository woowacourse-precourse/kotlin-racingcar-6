package racingcar

class Car(var name: String) {
    var distance = 0
    fun forward() {
        distance++
    }
}