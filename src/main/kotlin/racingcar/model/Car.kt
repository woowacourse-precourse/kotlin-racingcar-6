package racingcar.model

data class Car (val name: String, var moves: Int = 0) {
    fun move() {
        moves += 1
    }
}