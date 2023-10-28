package racingcar.model

import racingcar.resources.Comments.COMMA
import racingcar.resources.Comments.FINAL_WINNER_COMMENT
import racingcar.resources.Comments.MOVEMENT
import racingcar.resources.Comments.SEPARATOR
import racingcar.resources.Comments.SPACE
import racingcar.resources.GameValue.MOVEMENT_THRESHOLD_VALUE
import racingcar.resources.GameValue.MOVEMENT_VALUE
import racingcar.utils.generateRandomNumbers

class RacingCars(
    private var carList: List<Car>
) {

    fun moveRacingCars() {
        carList = carList.map { car ->
            when (getMovementState()) {
                MovementState.MOVE -> car.copy(
                    movement = car.movement + MOVEMENT_VALUE
                )

                MovementState.STOP -> car
            }
        }
    }

    private fun getMovementState(): MovementState {
        return if (generateRandomNumbers() >= MOVEMENT_THRESHOLD_VALUE) {
            MovementState.MOVE
        } else {
            MovementState.STOP
        }
    }

    fun getMovementResult(): List<String> {
        return carList.map { (name, movement) ->
            name + SEPARATOR + MOVEMENT.repeat(movement)
        }
    }

    fun getWinner(): String {
        val maxMovement = carList.maxOf { car -> car.movement }

        val winners = carList.filter { car ->
            car.movement == maxMovement
        }.map { it.name }.joinToString(COMMA + SPACE)

        return FINAL_WINNER_COMMENT + winners
    }
}
