package domain

import camp.nextstep.edu.missionutils.Console
import domain.Constant.INPUT_CAR_NAME_TEXT
import domain.Constant.NAME_DIVISION_NOTATION

class Car(private var name: String) {
    var moveCount = 0

    fun moveCount(): Int {
        return moveCount
    }

    fun moveForward(): Int {
        moveCount++
        return moveCount
    }

    fun moveStop(): Int {
        return moveCount
    }

    // 해결하는데 오래 걸린 부분
    override fun toString(): String {
        return "${name}"
    }
}
