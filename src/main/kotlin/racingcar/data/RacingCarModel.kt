package racingcar.data

import racingcar.ui.model.RoundStateModel

data class RacingCarModel(
    val carName: String,
    val moveForward: Int
)

fun RacingCarModel.toRoundStateModel(): RoundStateModel {
    return RoundStateModel(carName = carName, moveState = "-".repeat(moveForward))
}
