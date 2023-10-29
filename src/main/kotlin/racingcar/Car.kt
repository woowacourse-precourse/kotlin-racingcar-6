package racingcar

class Car(_name: String) {
    var name: String = _name
    var go: Int = 0

    fun goStraight() {
        go++
    }
}