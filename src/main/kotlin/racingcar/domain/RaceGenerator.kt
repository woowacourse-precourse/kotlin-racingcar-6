package racingcar.domain

import camp.nextstep.edu.missionutils.Console

class RaceGenerator {
  private val cars: MutableList<Car> = mutableListOf()
  private var numberOfMoves: Int = -1

  fun generateCars(): List<Car> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val input: String = Console.readLine()
    val carNames = checkCarNames(input)

    for (carName in carNames) {
      cars.add(Car(carName))
    }

    return cars
  }

  fun askNumberOfMoves(): Int {
    println("시도할 횟수는 몇 회인가요?")
    val input: String = Console.readLine()
    numberOfMoves = checkNumberOfMoves(input)

    return numberOfMoves
  }

  private fun checkCarNames(input: String): List<String> {
    val carNames: List<String> = input.split(",")

    if (carNames.size != carNames.toSet().size) {
      throw IllegalArgumentException("자동차 이름들을 구별되게 지어주세요.")
    }

    for (carName in carNames) {
      if (carName.isEmpty()) {
        throw IllegalArgumentException("자동차 이름을 입력해주세요.")
      }

      if (carName.length > 5) {
        throw IllegalArgumentException("자동차 이름을 5자 이하로 작성해주세요.")
      }
    }

    return carNames
  }

  private fun checkNumberOfMoves(input: String): Int {
    return input.toIntOrNull() ?: throw IllegalArgumentException("숫자를 입력해주세요.")
  }
}