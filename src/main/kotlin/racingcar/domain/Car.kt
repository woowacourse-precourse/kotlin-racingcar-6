package racingcar.domain

import racingcar.domain.DecisionMaker

class Car(name: String) {
    var carName: String = name
    var forward = 0


    fun goForward() {
        if (DecisionMaker().decideToMove()) {
            forward++
        }
    }
}