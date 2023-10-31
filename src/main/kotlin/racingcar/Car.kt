package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(_name: String) {
    var name: String = _name
    var go: Int = 0

    fun goStraight() {
        go++
    }
}