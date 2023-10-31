package racingcar.model

import racingcar.resources.GameValue

data class Car (
    val name: String,
    val movement: Int = GameValue.INITIAL_MOVEMENT_VALUE,
)