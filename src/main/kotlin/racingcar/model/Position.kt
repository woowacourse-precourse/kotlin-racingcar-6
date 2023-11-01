package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class Position: Comparable<Position>{
    private var position : Int = 0

    fun moveByRandom() {
        if(moveCheck())
            position++
    }

    private fun moveCheck(): Boolean {
        return Randoms.pickNumberInRange(0, 9) >= 4
    }

    override fun compareTo(other: Position): Int {
        return position - other.position
    }

    fun getPositionNumber(): Int {
        return position
    }
}