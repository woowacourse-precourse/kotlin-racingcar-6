package racingcar.model

class Car(private val _name: String) {

    val name: String
        get() = _name

    private var _distance = 0
    val distance: Int
        get() = _distance

    fun isMove(movable: Boolean) {
        if (movable) _distance++
    }

    fun isWinner(maxValue: Int): Boolean = _distance == maxValue
}