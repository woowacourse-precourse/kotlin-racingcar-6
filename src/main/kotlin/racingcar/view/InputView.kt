package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.domain.car.dto.input.CreateCarsDto

class InputView(
    private val inputValidator: InputValidator,
    private val inputParser: InputParser,
) {
    fun inputCreateCarsDto(): CreateCarsDto {
        println(INPUT_CAR_NAMES_MESSAGE)
        val input = readLine()
        inputValidator.validateCarNamesInput(input)
        return inputParser.parseToCreateCarsDto(input)
    }

    fun inputMaxRound(): Int {
        println(INPUT_MAX_ROUND_MESSAGE)
        val input = readLine()
        inputValidator.validateMaxRound(input)
        return inputParser.parseToMaxRound(input)
    }

    private fun readLine() = Console.readLine().trim()

    companion object {
        const val INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val INPUT_MAX_ROUND_MESSAGE = "시도할 횟수는 몇 회인가요?"
    }
}