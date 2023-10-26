package racingcar.game

import camp.nextstep.edu.missionutils.Randoms

class Car (private val name: String) {
    private var distance = STARTING_POINT

    override fun toString(): String {
        return "$name : ${"-".repeat(distance)}"
    }
    fun getDistance() = distance

    fun startEngine() {
        val engineLevel = Randoms.pickNumberInRange(0, 9)
        if(checkEngineAvailable(engineLevel)) {
            move()
        }
    }

    private fun checkEngineAvailable(engineLevel: Int): Boolean {
        if (engineLevel > MINIMUM_AVAILABLE_ENGINE_LEVEL) {
            return true
        }
        return false
    }

    private fun move() {
        distance++
    }

    companion object {
        private const val STARTING_POINT = 0
        private const val MINIMUM_AVAILABLE_ENGINE_LEVEL = 3
    }
}