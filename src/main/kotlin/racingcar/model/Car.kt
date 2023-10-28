package racingcar.model

import camp.nextstep.edu.missionutils.Randoms
import racingcar.Const

data class Car(
    private val _name: String,
    private var _forwardResult: String = "",
) {
    val name
        get() = _name
    val forwardCnt: Int
        get() = _forwardResult.length

    fun moveForward() {
        val enableMove = Randoms.pickNumberInRange(0, 9) >= 4
        if (enableMove) _forwardResult += Const.FORWARD_STRING
        println("$name : $_forwardResult")
    }
}