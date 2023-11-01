package racingcar.domain

class Car(name: String) {
    var carName: String = name.trim()
    var forward = 0


    fun goForward() {
        if (DecisionMaker().decideToMove()) {
            forward++
        }
    }
}