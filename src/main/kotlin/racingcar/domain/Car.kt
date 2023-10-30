package racingcar.domain

class Car(val name: String) {

    var advanceState = 0

    fun moveForward() {
        advanceState++
    }

}