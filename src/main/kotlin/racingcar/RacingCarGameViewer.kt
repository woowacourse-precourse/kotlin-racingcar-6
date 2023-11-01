package racingcar

class RacingCarGameViewer {

    fun showMoveResult(racingCar: RacingCar) {
        println(getMoveResult(racingCar))
    }

    private fun getMoveResult(racingCar: RacingCar): String {
        return racingCar.getName() + BLANKED_COLON + DASH.repeat(racingCar.getPosition())
    }

    companion object {
        private const val BLANKED_COLON = " : "
        private const val DASH = "-"
    }
}