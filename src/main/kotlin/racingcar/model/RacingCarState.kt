package racingcar.model

import racingcar.resources.Comments.FINAL_WINNER_COMMENT
import racingcar.resources.Comments.MOVEMENT
import racingcar.resources.Comments.SEPARATOR
import racingcar.resources.GameValue.MOVEMENT_THRESHOLD_VALUE
import racingcar.resources.GameValue.MOVEMENT_VALUE
import racingcar.utils.generateRandomNumbers

class RacingCarState(
    private var carList: List<Car>,
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

    private fun getMovementState(
        randomNumber : Int = generateRandomNumbers(),
    ): MovementState {
        return if (randomNumber >= MOVEMENT_THRESHOLD_VALUE) {
            MovementState.MOVE
        } else {
            MovementState.STOP
        }
    }

    fun getMovementResult(): String {
        return carList.map { (name, movement) : Car ->
            name + SEPARATOR + MOVEMENT.repeat(movement)
        }.joinToString("\n")
    }

    fun getWinner(): String {
        val maxMovement = carList.maxOf { car -> car.movement }

        val winners = carList.filter { car ->
            car.movement == maxMovement
        }.map { it.name }.joinToString()

        return FINAL_WINNER_COMMENT + winners
    }
}
