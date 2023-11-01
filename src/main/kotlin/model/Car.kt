package model

import util.Validator

class Car(val name: String, position: Int = 0) {
    private var _position: Int = position
    val position: Int get() = _position

    init {
        Validator().checkCarName(name)
    }

    fun move(speed: Int) {
        if(speed >= 4) _position++
    }


}