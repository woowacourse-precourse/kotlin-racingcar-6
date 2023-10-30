package racingcar

import racingcar.domain.Race
import racingcar.domain.Report
import racingcar.domain.User

fun main() {
    val userInput = User()
    var racingCars = userInput.namingCar()
    val totalAttempt = userInput.attemptNumber()
    val racing = Race()
    val reporter = Report()
    println("\n실행 결과")
    for (attemptIndex in 1..totalAttempt){
        racingCars = racing.racing(racingCars)
        reporter.status(racingCars)
        println()
    }
    val winner = reporter.checkWinner(racingCars)
    val result = reporter.raceResult(winner)

}
