package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

data class Car(
    private val _name: String,
    private var _position: Int = 0,
) {
    val name = _name
    val position = _position

    fun moveForward() {
        val enableMove = Randoms.pickNumberInRange(0, 9) >= 4
        if (enableMove) _position++
    }
}