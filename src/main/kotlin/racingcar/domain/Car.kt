package racingcar.domain

class Car (name: String) {
    var carName: String = name
    var score = 0


    fun goForward(): Int = score++
}