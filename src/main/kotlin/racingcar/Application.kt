package racingcar

import racingcar.domain.RaceGenerator

fun main() {
  val myRace = RaceGenerator()
  val racingCars = myRace.generateCars()
  val numberOfMoves = myRace.askNumberOfMoves()
}
