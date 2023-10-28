package racingcar.domain

class Commentator(private val cars: List<Car>, private val numberOfMoves: Int) {
  fun commentRace() {
    println()
    println("실행 결과")

    repeat(numberOfMoves) {
      for (car in cars) {
        println("${car.carName} : ${car.moveOrNot()}")
      }
      println()
    }
  }

  fun theWinnerIs() {

  }
}