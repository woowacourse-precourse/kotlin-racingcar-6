package racingcar.game

import camp.nextstep.edu.missionutils.Randoms

class Car (private val name: String) {
    private var distance = STARTING_POINT

    override fun toString(): String {
        return "$name : ${"-".repeat(distance)}"
    }
    fun getDistance() = distance

    fun getName() = name

    fun startEngine(): Int {
        val engineLevel = Randoms.pickNumberInRange(ENGINE_LEVEL_ZERO, ENGINE_LEVEL_MAX)
        if (checkEngineAvailable(engineLevel)) {
            move()
        }
        return engineLevel
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
        private const val ENGINE_LEVEL_ZERO = 0
        private const val ENGINE_LEVEL_MAX = 9
    }
}