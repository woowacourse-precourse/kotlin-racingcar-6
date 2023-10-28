package racingcar.domain.move

import numbers.NumberPicker

class RandomMoveDecider(
    val numberPicker: NumberPicker
) : MoveDecider {

    override fun nextMove(): Movement {
        val number = numberPicker.pick()
        if (number >= MIN_MOVE_NUMBER) {
            return Movement.FORWARD
        }
        return Movement.STAY
    }

    companion object {
        const val MIN_MOVE_NUMBER = 4
    }

}