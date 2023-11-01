package racingcar.domain

import racingcar.res.GuideMessage.ANNOUNCE_THE_WINNERS
import racingcar.res.GuideMessage.SHOW_EXECUTION_RESULT
import racingcar.utils.getRandomNumber

class Commentator(private val cars: List<Car>, private val numberOfMoves: Int) {
  fun commentRace() {
    println()
    println(SHOW_EXECUTION_RESULT)

    repeat(numberOfMoves) {
      for (car in cars) {
        car.moveOrNot(getRandomNumber())
        println("${car.carName} : ${car.record}")
      }
      println()
    }
  }

  fun theWinnerIs() {
    val maxRecord = cars.map{ it.record }.maxOf { it.length }
    val nameOfWinners = cars.filter { it.record.length == maxRecord }.map { it.carName }

    print(ANNOUNCE_THE_WINNERS)
    println(nameOfWinners.joinToString(", "))
  }
}