package racingcar.domain

class Car(name: String) {
    var carName: String = name
    var forward = 0


    fun goForward() {
        if (DecisionMaker().decideToMove()) {
            forward++
        }
    }
}