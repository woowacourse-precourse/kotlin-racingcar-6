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
    val maxRecord = cars.map{ it.record }.maxOf { it.length }
    val nameOfWinners = cars.filter { it.record.length == maxRecord }.map { it.carName }

    print("최종 우승자 : ")
    println(nameOfWinners.joinToString(", "))
  }
}