package racingcar.Model

class Car (val name: String, var moves: Int = 0) {
    fun move() {
        this.moves += 1
    }
}