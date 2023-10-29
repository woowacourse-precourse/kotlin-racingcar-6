package racingcar

import camp.nextstep.edu.missionutils.Randoms

data class Car(
    val name: String,
) {
    private var forward: Int = 0

    constructor(name: String, forward: Int): this(name){
        this.forward = forward
    }

    fun moveForward() {
        if (Randoms.pickNumberInRange(0, 9) >= MIN_MOVING_FORWARD_NUMBER)
            forward += 1
    }

    override fun toString(): String {
        var s = ""
        repeat(forward) { s += "-" }
        return "$name : $s"
    }

    companion object {
        const val MIN_MOVING_FORWARD_NUMBER = 4
    }
}