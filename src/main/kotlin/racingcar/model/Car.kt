package racingcar.model

import camp.nextstep.edu.missionutils.Randoms
import racingcar.Const

data class Car(
    private val _name: String,
    private var _forwardCnt: Int = 0,
) {
    val name
        get() = _name
    val forwardCnt: Int
        get() = _forwardCnt

    fun moveForward() {
        val enableMove = Randoms.pickNumberInRange(0, 9) >= 4
        if (enableMove) _forwardCnt += 1
        println("$name : ${Const.FORWARD_STRING.repeat(_forwardCnt)}")
    }
}