package racingcar.model

import java.lang.StringBuilder

data class Car(val name: String) {

    private var _move = Move(position = 0)
    val move get() = _move

    override fun toString(): String {
        val str = StringBuilder()
        str.append("$name : ")
        repeat(move.position) {
            str.append("-")
        }
        return str.toString()
    }

    fun attemptMove(condition: Int) {
        _move.checkMove(condition)
    }
}
