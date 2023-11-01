package racingcar

import racingcar.domain.Race
import racingcar.domain.Report
import racingcar.domain.User

fun main() {
    val user = User()
    var racingCars = user.namingCar()
    val totalAttempt = user.attemptNumber()
    val racing = Race()
    val reporter = Report()

    println("\n실행 결과")

    for (attemptIndex in 1..totalAttempt) {
        racingCars = racing.racing(racingCars)
        reporter.status(racingCars)
        println()
    }

    val winner = reporter.checkWinner(racingCars)
    reporter.raceResult(winner)
}
