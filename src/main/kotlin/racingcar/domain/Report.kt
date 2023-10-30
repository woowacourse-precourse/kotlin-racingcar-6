package racingcar.domain

class Report {

    fun status(racingCars: Map<String, Int>) {
        racingCars.forEach { (name, value) ->
            println("$name : ${"-".repeat(value)}")
        }
    }

    fun checkWinner(racingCars: Map<String, Int>): String {
        val maxCount = racingCars.values.maxOrNull() ?: return ""
        val winners = racingCars.filter { it.value == maxCount }.keys
        return winners.joinToString(", ")
    }

    fun raceResult() {}
}