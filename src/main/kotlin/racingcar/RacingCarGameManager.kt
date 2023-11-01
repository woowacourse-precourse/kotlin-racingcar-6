package racingcar

import camp.nextstep.edu.missionutils.Console

class RacingCarGameManager {
    private val validator = Validator()
    private var racingCars = listOf<RacingCar>()
    private var totalRound = 0

    fun getRacingCars(): List<RacingCar> = this.racingCars
    fun getTotalRound(): Int = this.totalRound

    fun setConfiguration() {
        setRacingCars()
        setTotalRound()
    }

    private fun setRacingCars() {
        val racingCars = mutableListOf<RacingCar>()
        val userInput = getUserInputWithPrintingMessage(CAR_NAME_MESSAGE)
        val carNames = validatedInputAsCarNames(userInput)

        carNames.map { name -> racingCars.add(RacingCar(name)) }

        this.racingCars = racingCars
    }

    private fun getUserInputWithPrintingMessage(message: String): String {
        println(message)
        return Console.readLine()
    }

    private fun validatedInputAsCarNames(input: String): List<String> {
        validator.checkHasNoBlank(input)
        validator.checkHasSeparator(input, COMMA)
        validator.checkHasNoDuplication(input.split(COMMA))
        validator.checkIsInBoundary(input.split(COMMA).size, MIN_CAR_NAME_COUNT)
        input.split(COMMA).map { data ->
            validator.checkIsInBoundary(data.length, MIN_CAR_NAME_LENGTH, MAX_CAR_NAME_LENGTH)
        }
        return input.split(COMMA)
    }

    private fun setTotalRound() {
        val userInput = getUserInputWithPrintingMessage(TOTAL_ROUND_MESSAGE)
        val totalRoundNumber = validatedInputAsTotalRoundNumber(userInput)
        this.totalRound = totalRoundNumber
    }

    private fun validatedInputAsTotalRoundNumber(input: String): Int {
        validator.checkHasNoBlank(input)
        validator.checkHasOnlyDigit(input)
        validator.checkIsInBoundary(Integer.parseInt(input), MIN_TOTAL_ROUND)
        return Integer.parseInt(input)
    }

    companion object {
        private const val COMMA = ","
        private const val CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        private const val TOTAL_ROUND_MESSAGE = "시도할 횟수는 몇 회인가요?"
        private const val MIN_CAR_NAME_LENGTH = 1
        private const val MAX_CAR_NAME_LENGTH = 5
        private const val MIN_CAR_NAME_COUNT = 2
        private const val MIN_TOTAL_ROUND = 1
    }
}