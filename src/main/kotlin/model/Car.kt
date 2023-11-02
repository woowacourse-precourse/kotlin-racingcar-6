package model

class Car(private val name: String) {
    private var _distance = 0
    val distance: Int
        get() = _distance

    fun isMove(movable: Boolean) {
        if (movable) _distance++
    }
}