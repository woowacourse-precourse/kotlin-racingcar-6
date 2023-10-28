package racingcar.domain

class Commentator(val cars: List<Car>, val numberOfMoves: Int) {
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