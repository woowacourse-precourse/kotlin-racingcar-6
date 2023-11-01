package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(name: String) {
    private val name: String
    private var location: Int
    private val minRandomNumber: Int = 0
    private val baseRandomNumber: Int = 4
    private val maxRandomNumber: Int = 9

    fun getName() = name
    fun getLocation() = location

    init {
        this.name = name
        this.location = 0
    }

    private fun canMoveForward(): Boolean {
        val randomNumber = Randoms.pickNumberInRange(minRandomNumber, maxRandomNumber)
        return randomNumber >= baseRandomNumber
    }

    fun tryToMoveForward() {
        if (canMoveForward()) location++
    }

    fun showResult() {
        println("${this.name} : ${"-".repeat(location)}")
    }
}