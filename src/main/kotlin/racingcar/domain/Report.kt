package racingcar.domain

class Report {

    fun status(racingCars: Map<String, Int>) {
        racingCars.forEach { (name, value) ->
            println("$name : ${"-".repeat(value)}")
        }
    }

    fun checkWinner() {}

    fun raceResult() {}
}