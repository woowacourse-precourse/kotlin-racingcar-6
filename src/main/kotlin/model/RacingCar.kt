package model

class RacingCar(
    val name: String,
    var position: Int = START_POSITION,
    private val moveStrategy: MoveStrategy
) {

    fun moveForward() {
        if (moveStrategy.canMove()) {
            position += POSITION_STEP
        }
    }

    companion object {
        const val START_POSITION = 0
        const val POSITION_STEP = 1
    }
}