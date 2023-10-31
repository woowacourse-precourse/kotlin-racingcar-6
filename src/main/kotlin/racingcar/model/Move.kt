package racingcar.model

data class Move(var position: Int) {
    private val minCondition = 4
    private val maxCondition = 9

    fun checkMove(condition: Int) {
        if (condition in minCondition..maxCondition) {
            moveForward()
        }
    }

    private fun moveForward() = this.position++
}
