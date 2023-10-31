package racingcar.domain

class Car {
    private lateinit var name: String
    private var score = 0

    fun goForward(): Int = score++
}