package model

class Car(val name: String, position: Int = 0) {
    private var _position: Int = position
    val position: Int get() = _position



}