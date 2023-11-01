package racingcar.domain

class Report {
    fun status(racingCars: Map<String, Int>) {
        racingCars.forEach { (name, value) ->
            println("$name : ${"-".repeat(value)}")
        }
    }

    fun checkWinner(racingCars: Map<String, Int>): String {
        val maxCount = racingCars.values.maxOrNull() ?: return ""
        return if (maxCount == 0) {
            ""
        } else {
            val winners = racingCars.filter { it.value == maxCount }.keys
            winners.joinToString(", ")
        }
    }

    fun raceResult(winner: String): Boolean {
        return if (winner.isEmpty()) {
            print("모두 출발하지 못해, 우승자가 없습니다")
            false
        } else {
            print("최종 우승자 : $winner")
            true
        }
    }
}