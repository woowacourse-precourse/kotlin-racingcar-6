package racingcar

import camp.nextstep.edu.missionutils.Console

class RacingCarGameManager {
    private var racingCars = listOf<RacingCar>()

    fun setConfiguration() {
        setRacingCars()
    }

    private fun setRacingCars() {
        val racingCars = mutableListOf<RacingCar>()
        val carNames = validatedCarNames()

        carNames.map { name -> racingCars.add(RacingCar(name)) }

        this.racingCars = racingCars
    }

    private fun validatedCarNames(): List<String> {
        val validator = Validator()
        val carNames = userEnteredCarNames()

        validator.validateCarNames(carNames)
        return carNames.split(COMMA)
    }

    private fun userEnteredCarNames(): String {
        println(CAR_NAME_MESSAGE)
        return Console.readLine()
    }

    companion object {
        private const val COMMA = ","
        private const val CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    }
}