package racingcar
import camp.nextstep.edu.missionutils.Randoms

class RacingCarGame(private val carNames: List<String>) {

    private val carPositions = initializeCarPositions()

    fun run(tryNum: Int): Map<String, Int> {
        repeat(tryNum) {
            updateCarPositions()
            displayCarPositions()
            println()
        }
        return carPositions
    }

    private fun initializeCarPositions(): MutableMap<String, Int> {
        val positions = mutableMapOf<String, Int>()
        carNames.forEach { car ->
            positions[car] = 0
        }
        return positions
    }

    private fun updateCarPositions() {
        carNames.forEach { car ->
            if (randomValue() >= 4) {
                carPositions[car] = carPositions[car]!! + 1
            }
        }
    }

    private fun displayCarPositions() {
        carNames.forEach { car ->
            println("$car : ${"-".repeat(carPositions[car]!!)}")
        }
    }

    private fun randomValue(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }
}

