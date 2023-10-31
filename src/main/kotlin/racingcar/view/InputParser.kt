package racingcar.view

import racingcar.domain.car.dto.input.CreateCarsDto

class InputParser {
    fun parseToCreateCarsDto(input: String) = CreateCarsDto(input.split(CAR_NAMES_DELIMITER))

    fun parseToMaxRound(input: String) = input.toInt()

    companion object {
        const val CAR_NAMES_DELIMITER = ", "
    }
}
