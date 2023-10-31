package racingcar

class Player(var name: String, var position: Int = 0) {
    override
    fun toString(): String {
        val scoreLine = "-".repeat(position)
        return "$name : $scoreLine\n"
    }

    fun move() = position++
}