package racingcar.domain

import camp.nextstep.edu.missionutils.Console
import racingcar.res.GuideMessage.ENTER_CAR_NAMES_GUIDEMESSAGE
import racingcar.res.GuideMessage.ENTER_NUMBER_OF_MOVES_GUIDEMESSAGE
import racingcar.res.ErrorMessage.BLANK_CAR_NAME_ERRORMESSAGE
import racingcar.res.ErrorMessage.INDISTINCTIVE_CAR_NAME_ERRORMESSAGE
import racingcar.res.ErrorMessage.NOT_PROPER_NUMBER_OF_MOVES_ERRORMESSAGE
import racingcar.res.ErrorMessage.OVER_5_LETTERS_CAR_NAME_ERRORMESSAGE

class RaceGenerator {
  private val cars: MutableList<Car> = mutableListOf()
  private var numberOfMoves: Int = -1

  fun generateCars(): List<Car> {
    println(ENTER_CAR_NAMES_GUIDEMESSAGE)
    val input: String = Console.readLine()
    val carNames = checkCarNames(input)

    for (carName in carNames) {
      cars.add(Car(carName))
    }

    return cars
  }

  fun askNumberOfMoves(): Int {
    println(ENTER_NUMBER_OF_MOVES_GUIDEMESSAGE)
    val input: String = Console.readLine()
    numberOfMoves = checkNumberOfMoves(input)

    return numberOfMoves
  }

  fun checkCarNames(input: String): List<String> {
    val carNames: List<String> = input.split(",")

    for (carName in carNames) {
      if (carName.isBlank()) {
        throw IllegalArgumentException(BLANK_CAR_NAME_ERRORMESSAGE)
      }

      if (carName.length > 5) {
        throw IllegalArgumentException(OVER_5_LETTERS_CAR_NAME_ERRORMESSAGE)
      }
    }

    if (carNames.size != carNames.toSet().size) {
      throw IllegalArgumentException(INDISTINCTIVE_CAR_NAME_ERRORMESSAGE)
    }

    return carNames
  }

  fun checkNumberOfMoves(input: String): Int {
    val result = input.toIntOrNull()

    if ((result == null) || (result < 0)) {
      throw IllegalArgumentException(NOT_PROPER_NUMBER_OF_MOVES_ERRORMESSAGE)
    }

    return result
  }
}