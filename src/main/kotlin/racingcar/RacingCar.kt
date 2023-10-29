package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingGame(private val cars: List<String>) {
    private val carPositions = mutableMapOf<String, Int>()

    init {
        for (car in cars) {
            carPositions[car] = 0
        }
    }

    fun racing(tryCount: Int) {
        println("\n실행 결과")
        repeat(tryCount) {
            racingCars()
            printProgress()
        }

        printResult()
    }

    private fun racingCars() {
        for (car in cars) {
            val randomValue = Randoms.pickNumberInRange(0, 9)
            if (randomValue >= 4) {
                carPositions[car] = carPositions[car]!! + 1
            }
        }
    }

    private fun printProgress() {
        for (car in cars) {
            val progress = "-".repeat(carPositions[car]!!)
            println("$car : $progress")
        }
        println()
    }

    private fun printResult() {
        val maxPosition = carPositions.values.maxOrNull()
        val winners = carPositions.filterValues { it == maxPosition }.keys.joinToString(", ")

        println("최종 우승자 : $winners")
    }
}