package racingcar

import camp.nextstep.edu.missionutils.Console

class RacingCarGenerator {
    private var racingCars = listOf<RacingCar>()

    fun getRacingCars(): List<RacingCar> = racingCars

    fun createRacingCars() {
        val racingCars = mutableListOf<RacingCar>()
        val carNames = userEnteredCarNames()

        carNames.map { name -> racingCars.add(RacingCar(name)) }

        this.racingCars = racingCars
    }

    private fun userEnteredCarNames(): List<String> {
        println(CAR_NAME_MESSAGE)
        return validatedCarNames(Console.readLine())
    }

    private fun validatedCarNames(input: String): List<String> {
        val validator = Validator()

        validator.validateCarNames(input)
        return input.split(COMMA)
    }

    companion object {
        private const val COMMA = ","
        private const val CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    }
}